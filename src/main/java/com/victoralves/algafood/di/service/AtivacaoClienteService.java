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

//    @TipoNotificador(NivelUrgencia.SEM_URGENCIA)
//    @Autowired
//    private Notificador notificador;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void ativar(Cliente cliente) {
        cliente.ativar();
        // notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
        //dizer para o container que o cliente esta ativo nesse momento

        eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
    }

}
