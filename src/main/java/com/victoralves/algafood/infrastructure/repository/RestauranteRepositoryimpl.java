package com.victoralves.algafood.infrastructure.repository;

import com.victoralves.algafood.domain.model.Cozinha;
import com.victoralves.algafood.domain.model.Restaurante;
import com.victoralves.algafood.domain.repository.RestauranteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestauranteRepositoryimpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Restaurante> listar(){
        TypedQuery<Restaurante> query = manager.createQuery("from Restaurante",Restaurante.class);

        return query.getResultList();
    }
    @Override
    public Restaurante buscar(Long id){
        return manager.find(Restaurante.class,id);
    }

    @Transactional
    @Override
    public Restaurante salvar(Restaurante restaurante){
        return manager.merge(restaurante);
    }

    @Transactional
    @Override
    public void remover(Long id){
        Restaurante restaurante = buscar(id);
        if (restaurante == null) {
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(restaurante);
    }
}
