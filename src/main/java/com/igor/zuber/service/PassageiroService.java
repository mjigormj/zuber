package com.igor.zuber.service;

import com.igor.zuber.domain.Passageiro;
import com.igor.zuber.domain.dto.PassageiroDTO;
import com.igor.zuber.domain.mapper.PassageiroMapper;
import com.igor.zuber.repositoy.PassageiroRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PassageiroService {

    @Autowired
    private PassageiroRepository repository;

    @Autowired
    private PassageiroMapper mapper;

    public void cadastrarPassageiro(Passageiro passageiro) {
//        try {
            repository.cadastrar(passageiro.getNome(), passageiro.getEmail(), passageiro.getDtNascimento(), passageiro.getCpf());
//        } catch (Exception e){
//            log.error("Passageiro já cadastrado");
//        }
    }

    public void apagar(String email) {
        try {
            repository.apagar(email);
        } catch (Exception e){
            log.error("Erro ao remover passageiro");
        }
    }

    public PassageiroDTO get(String email) {
            return mapper.toDomainDTO(repository.get(email));
    }

    public void atualizarMotorista(Passageiro passageiro) {
        try {
            repository.atualizar(passageiro.getNome(), passageiro.getEmail(), passageiro.getDtNascimento());
        } catch (Exception e){
            log.error("Erro ao atualizar dados: " + passageiro.getEmail());
        }
    }
}
