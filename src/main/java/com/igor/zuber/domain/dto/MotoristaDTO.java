package com.igor.zuber.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MotoristaDTO implements Serializable {

    private String nome;
    private String veiculo;

}
