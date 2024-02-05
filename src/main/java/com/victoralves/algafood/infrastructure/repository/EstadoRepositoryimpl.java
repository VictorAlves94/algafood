package com.victoralves.algafood.infrastructure.repository;

import com.victoralves.algafood.domain.model.Cozinha;
import com.victoralves.algafood.domain.model.Estado;
import com.victoralves.algafood.domain.repository.CozinhaRepository;
import com.victoralves.algafood.domain.repository.EstadoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstadoRepositoryimpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Estado> listar(){
        TypedQuery<Estado> query = manager.createQuery("from Estado",Estado.class);

        return query.getResultList();
    }
    @Override
    public Estado buscar(Long id){
        return manager.find(Estado.class,id);
    }

    @Transactional
    @Override
    public Estado salvar(Estado estado){
        return manager.merge(estado);
    }

    @Transactional
    @Override
    public void remover(Estado estado){
        estado = buscar(estado.getId());
        manager.remove(estado);
    }
}
