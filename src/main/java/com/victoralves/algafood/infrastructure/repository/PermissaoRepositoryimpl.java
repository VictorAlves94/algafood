package com.victoralves.algafood.infrastructure.repository;

import com.victoralves.algafood.domain.model.Cozinha;
import com.victoralves.algafood.domain.model.Permissao;
import com.victoralves.algafood.domain.repository.CozinhaRepository;
import com.victoralves.algafood.domain.repository.PermissaoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PermissaoRepositoryimpl implements PermissaoRepository {

    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Permissao> listar(){
        TypedQuery<Permissao> query = manager.createQuery("from Permissao",Permissao.class);

        return query.getResultList();
    }
    @Override
    public Permissao buscar(Long id){
        return manager.find(Permissao.class,id);
    }

    @Transactional
    @Override
    public Permissao salvar(Permissao permissao){
        return manager.merge(permissao);
    }

    @Transactional
    @Override
    public void remover(Permissao permissao){
        permissao = buscar(permissao.getId());
        manager.remove(permissao);
    }
}
