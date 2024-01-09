package com.igor.zuber.service;

import com.igor.zuber.domain.Motorista;
import com.igor.zuber.domain.dto.MotoristaDTO;
import com.igor.zuber.domain.mapper.MotoristaMapper;
import com.igor.zuber.repositoy.MotoristaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MotoristaService {

    @Autowired
    private MotoristaRepository repository;

    @Autowired
    private MotoristaMapper mapper;

    public void cadastrarMotorista(Motorista motorista) {
        try {
            repository.cadastrar(motorista.getNome(), motorista.getVeiculo(), motorista.getCnh());
        } catch (Exception e){
            log.error("CNH já cadastrada: " + motorista.getCnh());
        }
    }

    public void apagar(Long cnh) {
        try {
            repository.apagar(cnh);
        } catch (Exception e){
            log.error("Erro ao remover motorista");
        }
    }

    public MotoristaDTO get(Long cnh) {
            return mapper.toDomainDTO(repository.get(cnh));
    }

    public void atualizarMotorista(Motorista motorista) {
        try {
            repository.atualizar(motorista.getNome(), motorista.getVeiculo(), motorista.getCnh());
            log.info("Novo motorista atualizado: " + motorista.getNome());
        } catch (Exception e){
            log.error("Erro ao atualizar dados: " + motorista.getCnh());
        }
    }
}
