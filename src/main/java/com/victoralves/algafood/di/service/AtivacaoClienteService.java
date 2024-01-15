package com.victoralves.algafood.di.service;

import com.victoralves.algafood.di.modelo.Cliente;
import com.victoralves.algafood.di.notificacao.NivelUrgencia;
import com.victoralves.algafood.di.notificacao.Notificador;
import com.victoralves.algafood.di.notificacao.TipoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {
    @TipoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }

}
