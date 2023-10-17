package com.igor.zuber.service;

import com.igor.zuber.domain.Motorista;
import com.igor.zuber.repositoy.MotoristaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MotoristaService {

    @Autowired
    private MotoristaRepository repository;

    public void cadastrarMotorista(Motorista motorista) {
        try {
            repository.cadastrar(motorista.getNome(), motorista.getVeiculo(), motorista.getCnh());
            log.info("Novo motorista cadastrado: " + motorista.getNome());
        } catch (Exception e){
            log.error("CNH já cadastrada: " + motorista.getCnh());
        }
    }

    public void apagar(Long cnh) {
        try {
            repository.apagar(cnh);
            log.info("Motorista removido da tabela: " + cnh);
        } catch (Exception e){
            log.error("Erro ao remover motorista");
        }
    }

    public Motorista get(Long cnh) {
        try {
            return repository.get(cnh);
        } catch (Exception e){
            log.error("Motorista não encontrado");
        }
        return null;
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
