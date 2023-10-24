package com.igor.zuber.domain.mapper;

import com.igor.zuber.domain.Passageiro;
import com.igor.zuber.domain.dto.PassageiroDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PassageiroMapper {

    @Autowired
    private ModelMapper modelMapper;

    public static Passageiro toDomain(Map<String, Object> response){
        return Passageiro.builder()
                .nome((String) response.get("nome"))
                .email((String) response.get("email"))
                .cpf((String) response.get("cpf"))
                .dtNascimento((String) response.get("dt_nascimento"))
                .build();
    }

    public PassageiroDTO toDomainDTO(Passageiro passageiro){
        return modelMapper.map(passageiro, PassageiroDTO.class);
    }
}