package com.victoralves.algafood.infrastructure.repository;

import com.victoralves.algafood.domain.model.Cozinha;
import com.victoralves.algafood.domain.model.FormaPagamento;
import com.victoralves.algafood.domain.repository.CozinhaRepository;
import com.victoralves.algafood.domain.repository.FormaPagamentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FormaPagamentoRepositoryimpl implements FormaPagamentoRepository {

    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<FormaPagamento> listar(){
        TypedQuery<FormaPagamento> query = manager.createQuery("from FormaPagamento",FormaPagamento.class);

        return query.getResultList();
    }
    @Override
    public FormaPagamento buscar(Long id){
        return manager.find(FormaPagamento.class,id);
    }

    @Transactional
    @Override
    public FormaPagamento salvar(FormaPagamento formaPagamento){
        return manager.merge(formaPagamento);
    }

    @Transactional
    @Override
    public void remover(FormaPagamento pagamento){
        pagamento = buscar(pagamento.getId());
        manager.remove(pagamento);
    }
}
