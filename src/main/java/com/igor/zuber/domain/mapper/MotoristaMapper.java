package com.igor.zuber.domain.mapper;

import com.igor.zuber.domain.Motorista;
import com.igor.zuber.domain.dto.MotoristaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MotoristaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public static Motorista toDomain(Map<String, Object> response){
        return Motorista.builder()
                .nome((String) response.get("nome"))
                .cnh((Long) response.get("cnh"))
                .veiculo((String) response.get("veiculo"))
                .build();
    }

    public MotoristaDTO toDomainDTO(Motorista response){
        return modelMapper.map(response, MotoristaDTO.class);
    }
}