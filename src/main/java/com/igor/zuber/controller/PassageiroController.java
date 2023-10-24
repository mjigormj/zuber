package com.igor.zuber.controller;

import com.igor.zuber.domain.Passageiro;
import com.igor.zuber.domain.dto.PassageiroDTO;
import com.igor.zuber.service.PassageiroService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passageiro")
public class PassageiroController {

    @Autowired
    private PassageiroService service;

    @PostMapping
    public ResponseEntity<String> cadastrarPassageiro(@RequestBody @NotNull Passageiro passageiro){
        service.cadastrarPassageiro(passageiro);
        return new ResponseEntity<>("Passageiro salvo com sucesso", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> apagarPassageiro(@RequestBody @NotNull Passageiro passageiro){
        service.apagar(passageiro.getEmail());
        return new ResponseEntity<>("Passageiro removido com sucesso", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PassageiroDTO> getPassageiro(@RequestBody @NotNull Passageiro passageiro){
        var response = service.get(passageiro.getEmail());
        if(response == null || response.getNome().isBlank())
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
