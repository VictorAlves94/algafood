package com.victoralves.algafood.service;

import com.victoralves.algafood.domain.exception.EntidadeEmUsoException;
import com.victoralves.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.victoralves.algafood.domain.model.Estado;
import com.victoralves.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;


    public Estado salvar(Estado estado){
        return estadoRepository.save(estado);
    }


    public void excluir(Long id) {
        try {

            estadoRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadadstro de Estado com o código %d", id)
            );


        }catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format("O Estado de código %d não pode ser excluido, pois está em uso.", id)
            );


        }
    }
}
