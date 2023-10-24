package com.igor.zuber.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class PassageiroDTO {
    private String email;
    private String nome;
    private String dtNascimento;
}
