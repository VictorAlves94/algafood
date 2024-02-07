package com.victoralves.algafood.service;

import com.victoralves.algafood.domain.model.Cozinha;
import com.victoralves.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CozinhaService {
@Autowired
    private CozinhaRepository cozinhaRepository;

public Cozinha salvar(Cozinha cozinha){
    return cozinhaRepository.salvar(cozinha);

}
}
