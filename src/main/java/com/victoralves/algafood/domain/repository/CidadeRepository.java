package com.victoralves.algafood.domain.repository;

import com.victoralves.algafood.domain.model.Cidade;
import com.victoralves.algafood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade,Long> {

}
