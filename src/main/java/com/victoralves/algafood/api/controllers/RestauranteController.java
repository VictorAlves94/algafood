package com.victoralves.algafood.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.victoralves.algafood.domain.exception.EntidadeEmUsoException;
import com.victoralves.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.victoralves.algafood.domain.model.Restaurante;
import com.victoralves.algafood.domain.repository.RestauranteRepository;
import com.victoralves.algafood.service.RestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository repository;

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public List<Restaurante> listar() {
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> buscar(@PathVariable Long id) {
        Restaurante restaurante = repository.findby(id);


        if (restaurante != null) {
            return ResponseEntity.ok(restaurante);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
        try {
            restaurante = restauranteService.salvar(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante){
        try {
            Restaurante restauranteAtual = repository.buscar(id);

            if (restauranteAtual != null) {
                BeanUtils.copyProperties(restaurante, restauranteAtual, "id");

                restauranteAtual = restauranteService.salvar(restauranteAtual);
                return ResponseEntity.ok(restauranteAtual);
            }

            return ResponseEntity.notFound().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizarParcial(@PathVariable Long id,@RequestBody Map<String, Object> campos){
        Restaurante restauranteAtual = repository.buscar(id);
        if (restauranteAtual == null){
            return ResponseEntity.notFound().build();
        }
        merge(campos, restauranteAtual);

    return atualizar(id, restauranteAtual);

    }


    @DeleteMapping("/{restaurante_id}")
    public ResponseEntity<Restaurante> delete(@PathVariable Long restaurante_id){
        try {
            restauranteService.excluir(restaurante_id);
            return ResponseEntity.noContent().build();

        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }catch (
                EntidadeEmUsoException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    private void merge(Map<String, Object> camposOrigem, Restaurante restauranteDestino){
        ObjectMapper objectMapper = new ObjectMapper();
        Restaurante restauranteOrigem = objectMapper.convertValue(camposOrigem, Restaurante.class);


        camposOrigem.forEach((nomePropriedade, valorPropiedade)-> {
            Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
            field.setAccessible(true);

            Object novoValor = ReflectionUtils.getField(field,restauranteOrigem);

            ReflectionUtils.setField(field, restauranteDestino ,novoValor);
        });
    }
}




