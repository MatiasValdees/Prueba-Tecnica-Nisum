package com.nisum.desafio.infrastructure.adapter.in.rest.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@JsonPropertyOrder({ "status", "timestamp", "data" })
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WrapperResponse<T> {
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private String timestamp;
    private T data;
}
