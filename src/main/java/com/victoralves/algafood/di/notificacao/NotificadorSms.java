package com.victoralves.algafood.di.notificacao;

import com.victoralves.algafood.di.modelo.Cliente;
import org.springframework.stereotype.Component;
@Component
public class NotificadorSms implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do SMS através do telefone %s: %s\n",
                cliente.getNome(), cliente.getTelefone(),mensagem);
    }
}


