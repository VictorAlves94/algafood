package com.victoralves.algafood.domain.repository;

import com.victoralves.algafood.domain.model.FormaPagamento;
import com.victoralves.algafood.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {
    List<Permissao> listar();
    Permissao buscar(Long id);
    Permissao salvar(Permissao permissao);
    void remover(Permissao permissao);
}
