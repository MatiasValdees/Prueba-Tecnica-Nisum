INSERT INTO country_codes (id, name, code, country_id) VALUES
(1, 'Chile', '+56', 1001),
(2, 'Argentina', '+54', 1002),
(3, 'Perú', '+51', 1003),
(4, 'Brasil', '+55', 1004),
(5, 'Colombia', '+57', 1005);

INSERT INTO city_codes (id, name, code, country_code_id) VALUES
(1, 'Santiago', '2', 1),
(2, 'Valparaíso', '32', 1),
(3, 'Buenos Aires', '11', 2),
(4, 'Córdoba', '351', 2),
(5, 'Lima', '1', 3),
(6, 'Arequipa', '54', 3),
(7, 'Sao Paulo', '11', 4),
(8, 'Rio de Janeiro', '21', 4),
(9, 'Bogotá', '1', 5),
(10, 'Medellín', '4', 5);


INSERT INTO users (
    id, name, email, password, created_at, modified_at, last_login, active
) VALUES (
    'b3a8a5c0-2e49-4f02-91e3-ff2be2d8f0e6',
    'Matias Valdés',
    'mvaldes@nisum.com',
    '$2a$10$DF1WsrnPyq4ZFimaN8WAlOw5pefKsBhgqy72wSPpuuLVMU8Yy698y',
    '2025-04-08 10:00:00',
    '2025-04-08 10:05:00',
    '2025-04-08 10:10:00',
    true
);

INSERT INTO security_parameters (
    min_length,
    max_length,
    upper_case,
    lower_case,
    special_character,
    number
) VALUES (
    4,
    10,
    false,
    false,
    false,
    false
);