package com.nisum.desafio.infrastructure.adapter.in.rest.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.time.LocalDateTime;

@JsonPropertyOrder({ "status", "timestamp", "data" })
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WrapperResponse<T> {
    private String status = "OK";

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp= LocalDateTime.now();

    private T data;

    public WrapperResponse(T list) {
        this.data = list;
    }
}
