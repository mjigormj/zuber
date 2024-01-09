package com.igor.zuber.domain.dto;

import com.igor.zuber.domain.Motorista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MotoristaDTO implements Serializable {

    public MotoristaDTO(Motorista motorista){
        this.nome = motorista.getNome();
        this.veiculo = motorista.getVeiculo();
    }

    private String nome;
    private String veiculo;

}
