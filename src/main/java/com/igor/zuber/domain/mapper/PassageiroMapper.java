package com.igor.zuber.domain.mapper;

import com.igor.zuber.domain.Motorista;
import com.igor.zuber.domain.Passageiro;

import java.util.Map;

public class PassageiroMapper {
    public static Passageiro toDomain(Map<String, Object> response){
        return Passageiro.builder()
                .nome((String) response.get("nome"))
                .email((String) response.get("email"))
                .cpf((String) response.get("cpf"))
                .dtNascimento((String) response.get("dt_nascimento"))
                .build();
    }
}
