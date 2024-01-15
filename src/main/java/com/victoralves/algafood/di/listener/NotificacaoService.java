package com.victoralves.algafood.di.listener;

import com.victoralves.algafood.di.notificacao.NivelUrgencia;
import com.victoralves.algafood.di.notificacao.Notificador;
import com.victoralves.algafood.di.notificacao.TipoNotificador;
import com.victoralves.algafood.di.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {
    @Autowired
    @TipoNotificador(NivelUrgencia.SEM_URGENCIA)
    private Notificador notificador;


    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event){
       notificador.notificar( event.getCliente() , " agora está ativo");
    }
}
