package com.victoralves.algafood.api.controllers;

import com.victoralves.algafood.domain.model.Cozinha;
import com.victoralves.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cozinhas", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class CozinhaController {
    @Autowired
    private CozinhaRepository cozinhaRepository;
    @GetMapping
    public List<Cozinha> listar(){
    return cozinhaRepository.listar();
    }

    @GetMapping("/{id}")
    public Cozinha buscar(@PathVariable Long id){
        return cozinhaRepository.buscar(id);
    }
}
