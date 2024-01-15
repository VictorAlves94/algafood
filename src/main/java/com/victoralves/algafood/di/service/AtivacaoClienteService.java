package com.victoralves.algafood.di.service;

import com.victoralves.algafood.di.modelo.Cliente;
import com.victoralves.algafood.di.notificacao.NivelUrgencia;
import com.victoralves.algafood.di.notificacao.Notificador;
import com.victoralves.algafood.di.notificacao.TipoNotificador;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void ativar(Cliente cliente) {
        cliente.ativar();
        eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
    }

}
