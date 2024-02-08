package com.victoralves.algafood.service;

import com.victoralves.algafood.domain.exception.EntidadeEmUsoException;
import com.victoralves.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.victoralves.algafood.domain.model.Cozinha;
import com.victoralves.algafood.domain.model.Restaurante;
import com.victoralves.algafood.domain.repository.CozinhaRepository;
import com.victoralves.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinha_id = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.buscar(cozinha_id);

        if (cozinha == null){
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de cozinha com código %d", cozinha_id)
            );
        }
        restaurante.setCozinha(cozinha);
        return restauranteRepository.salvar(restaurante);
    }




public void excluir(Long restaurante_id){
    try {

        restauranteRepository.remover(restaurante_id);
    }catch (EmptyResultDataAccessException e){
        throw new EntidadeNaoEncontradaException(
                String.format("Não existe cadadstro de cozinha com o código %d", restaurante_id)
        );


    }catch (DataIntegrityViolationException e){
        throw new EntidadeEmUsoException(
                String.format("Cozinha de código %d não pode ser removida, pois está em uso.", restaurante_id)
        );

        }

}
}
