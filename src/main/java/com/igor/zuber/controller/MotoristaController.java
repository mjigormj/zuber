package com.igor.zuber.controller;

import com.igor.zuber.domain.Motorista;
import com.igor.zuber.domain.dto.MotoristaDTO;
import com.igor.zuber.service.MotoristaService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaService service;

    @PostMapping
    public ResponseEntity cadastrarMotorista(@RequestBody @NotNull Motorista motorista, UriComponentsBuilder uriBuilder){
        service.cadastrarMotorista(motorista);

        var uri = uriBuilder.path("/motorista/{cnh}").buildAndExpand(motorista.getCnh()).toUri();

//        return new ResponseEntity("Motorista salvo com sucesso", HttpStatus.OK);
        return ResponseEntity.created(uri).body(new MotoristaDTO(motorista));
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
    public ResponseEntity<MotoristaDTO> getMotorista(@PathVariable @NotNull Long cnh){
        var response = service.get(cnh);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
