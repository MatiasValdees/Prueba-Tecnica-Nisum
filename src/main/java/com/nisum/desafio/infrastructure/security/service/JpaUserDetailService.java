package com.nisum.desafio.infrastructure.security.service;

import com.nisum.desafio.domain.ports.in.usecases.user.IUpdateLastLoginUseCase;
import com.nisum.desafio.domain.ports.in.usecases.user.find.IFindUserByEmailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaUserDetailService implements UserDetailsService {
    private final IFindUserByEmailUseCase iFindUserByEmailUseCase;
    private final IUpdateLastLoginUseCase updateLastLoginUseCase;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = iFindUserByEmailUseCase.execute(username);
        List<GrantedAuthority> role = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        updateLastLoginUseCase.execute(user);
        return new User(
                user.getEmail(),
                user.getPassword(),
                user.isActive(),
                true,
                true,
                true,
                role
        );
    }
}
