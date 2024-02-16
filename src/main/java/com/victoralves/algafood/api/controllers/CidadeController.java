package com.victoralves.algafood.api.controllers;


import com.victoralves.algafood.domain.exception.EntidadeEmUsoException;
import com.victoralves.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.victoralves.algafood.domain.model.Cidade;
import com.victoralves.algafood.domain.model.Cozinha;
import com.victoralves.algafood.domain.model.Estado;
import com.victoralves.algafood.domain.model.Restaurante;
import com.victoralves.algafood.domain.repository.CidadeRepository;
import com.victoralves.algafood.service.CidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CidadeService cidadeService;


    @GetMapping
    public List<Cidade> listar(){
        return cidadeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> buscar(@PathVariable  Long id){
        Cidade cidade = cidadeRepository.buscar(id);

        if(cidade != null){
            return ResponseEntity.ok(cidade);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Cidade adicionar (@RequestBody Cidade cidade){
        return cidadeService.salvar(cidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Cidade cidade){
       try{
         Cidade cidadeAtual = cidadeRepository.buscar(id);

           if (cidadeAtual != null) {
               BeanUtils.copyProperties(cidade, cidadeAtual, "id");

               cidadeAtual = cidadeService.salvar(cidadeAtual);
               return ResponseEntity.ok(cidadeAtual);
           }

           return ResponseEntity.notFound().build();

       } catch (EntidadeNaoEncontradaException e) {
           return ResponseEntity.badRequest()
                   .body(e.getMessage());
       }


       }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cidade> deletar(@PathVariable Long id){
        try {
            cidadeService.excluir(id);
            return ResponseEntity.noContent().build();

        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }catch (
                EntidadeEmUsoException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


}
