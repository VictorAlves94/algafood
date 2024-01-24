package com.victoralves.algafood.jpa;

import com.victoralves.algafood.domain.model.Cozinha;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CadastroCozinha {
    @PersistenceContext
    private EntityManager manager;

    public List<Cozinha> listar(){
     TypedQuery<Cozinha> query = manager.createQuery("from Cozinha",Cozinha.class);

    return query.getResultList();

    }

    public Cozinha adicionar(Cozinha cozinha){
       return manager.merge(cozinha);
    }
}
