package com.igor.zuber.controller;

import com.igor.zuber.domain.Motorista;
import com.igor.zuber.service.MotoristaService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaService service;

    @PostMapping
    public ResponseEntity<String> cadastrarMotorista(@RequestBody @NotNull Motorista motorista){
        service.cadastrarMotorista(motorista);
        return new ResponseEntity<>("Motorista salvo com sucesso", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> atualizarMotorista(@RequestBody @NotNull Motorista motorista){
        service.atualizarMotorista(motorista);
        return new ResponseEntity<>("Dados do motorista atualizados com sucesso", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> apagarMotorista(@RequestBody @NotNull Motorista motorista){
        service.apagar(motorista.getCnh());
        return new ResponseEntity<>("Motorista removido com sucesso", HttpStatus.OK);
    }

    @GetMapping("/{cnh}")
    public ResponseEntity<Motorista> getMotorista(@PathVariable @NotNull Long cnh){
        var response = service.get(cnh);
        if(response == null || response.getNome().isBlank())
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
