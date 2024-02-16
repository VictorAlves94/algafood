package com.victoralves.algafood.domain.repository;

import com.victoralves.algafood.domain.model.Cozinha;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{

    //List<Cozinha> consultarPorNome(String nome);

}
