package com.victoralves.algafood.domain.repository;

import com.victoralves.algafood.domain.model.Cidade;
import com.victoralves.algafood.domain.model.Cozinha;

import java.util.List;

public interface CidadeRepository {
    List<Cidade> listar();
    Cidade buscar(Long id);
    Cidade salvar(Cidade cidade);
    void remover(Long id);
}
