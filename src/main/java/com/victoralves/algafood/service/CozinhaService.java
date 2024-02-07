package com.victoralves.algafood.service;

import com.victoralves.algafood.domain.exception.EntidadeEmUsoException;
import com.victoralves.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.victoralves.algafood.domain.model.Cozinha;
import com.victoralves.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CozinhaService {
@Autowired
    private CozinhaRepository cozinhaRepository;

public Cozinha salvar(Cozinha cozinha){
    return cozinhaRepository.salvar(cozinha);

}
public void excluir(Long cozinha_id){
    try {
        cozinhaRepository.remover(cozinha_id);
    }catch (EmptyResultDataAccessException e){
        throw new EntidadeNaoEncontradaException(
                String.format("Não existe cadadstro de cozinha com o código %d", cozinha_id)
        );


    }catch (DataIntegrityViolationException e){
        throw new EntidadeEmUsoException(
                String.format("Cozinha de código %d não pode ser removida, pois está em uso.", cozinha_id)
        );


        }

}
}
