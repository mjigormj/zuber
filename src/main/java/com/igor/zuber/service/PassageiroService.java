package com.igor.zuber.service;

import com.igor.zuber.domain.Passageiro;
import com.igor.zuber.repositoy.PassageiroRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PassageiroService {

    @Autowired
    private PassageiroRepository repository;

    public void cadastrarPassageiro(Passageiro passageiro) {
        try {
            repository.cadastrar(passageiro.getNome(), passageiro.getEmail(), passageiro.getDtNascimento(), passageiro.getCpf());
            log.info("Novo passageiro cadastrado: " + passageiro.getNome());
        } catch (Exception e){
            log.error("Passageiro já cadastrado");
        }
    }

    public void apagar(String email) {
        try {
            repository.apagar(email);
            log.info("Passageiro removido da tabela: " + email);
        } catch (Exception e){
            log.error("Erro ao remover passageiro");
        }
    }

    public Passageiro get(String email) {
        try {
            return repository.get(email);
        } catch (Exception e){
            log.error("Passageiro não encontrado");
        }
        return null;
    }

    public void atualizarMotorista(Passageiro passageiro) {
        try {
            repository.atualizar(passageiro.getNome(), passageiro.getEmail(), passageiro.getDtNascimento());
            log.info("Novo passageiro atualizado: " + passageiro.getNome());
        } catch (Exception e){
            log.error("Erro ao atualizar dados: " + passageiro.getEmail());
        }
    }
}
