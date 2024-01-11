package com.victoralves.algafood.di.service;

import com.victoralves.algafood.di.modelo.Cliente;
import com.victoralves.algafood.di.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AtivacaoClienteService {
    @Autowired(required = false)
    private List<Notificador> notificadores;

    public AtivacaoClienteService(List<Notificador> notificador) {
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        for (Notificador notificador : notificadores){
          notificador.notificar(cliente, "Seu cadastro no sistema está atívo!");
      }
    }


}
