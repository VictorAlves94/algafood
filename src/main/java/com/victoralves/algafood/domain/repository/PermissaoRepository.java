package com.victoralves.algafood.domain.repository;

import com.victoralves.algafood.domain.model.FormaPagamento;
import com.victoralves.algafood.domain.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
}
