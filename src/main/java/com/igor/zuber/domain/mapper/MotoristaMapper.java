package com.igor.zuber.domain.mapper;

import com.igor.zuber.domain.Motorista;

import java.util.Map;

public class MotoristaMapper {
    public static Motorista toDomain(Map<String, Object> response){
        return Motorista.builder()
                .nome((String) response.get("nome"))
                .cnh((Long) response.get("cnh"))
                .veiculo((String) response.get("veiculo"))
                .build();
    }
}
