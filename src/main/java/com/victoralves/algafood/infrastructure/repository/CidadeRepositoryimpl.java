package com.victoralves.algafood.infrastructure.repository;

import com.victoralves.algafood.domain.model.Cidade;
import com.victoralves.algafood.domain.model.Cozinha;
import com.victoralves.algafood.domain.repository.CidadeRepository;
import com.victoralves.algafood.domain.repository.CozinhaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CidadeRepositoryimpl implements CidadeRepository {

    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Cidade> listar(){
        TypedQuery<Cidade> query = manager.createQuery("from Cidade",Cidade.class);

        return query.getResultList();
    }
    @Override
    public Cidade buscar(Long id){
        return manager.find(Cidade.class,id);
    }

    @Transactional
    @Override
    public Cidade salvar(Cidade cidade){
        return manager.merge(cidade);
    }

    @Transactional
    @Override
    public void remover(Cidade cidade){
        cidade = buscar(cidade.getId());
        manager.remove(cidade);
    }
}
