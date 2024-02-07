package com.victoralves.algafood.infrastructure.repository;

import com.victoralves.algafood.domain.model.Cozinha;
import com.victoralves.algafood.domain.repository.CozinhaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CozinhaRepositoryimpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Cozinha> listar(){
        TypedQuery<Cozinha> query = manager.createQuery("from Cozinha",Cozinha.class);

        return query.getResultList();
    }
    @Override
    public Cozinha buscar(Long id){
        return manager.find(Cozinha.class,id);
    }

    @Transactional
    @Override
    public Cozinha salvar(Cozinha cozinha){
        return manager.merge(cozinha);
    }

    @Transactional
    @Override
    public void remover(Long id){
        Cozinha cozinha = buscar(id);
        if (cozinha == null) {
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(cozinha);
    }
}
