package com.victoralves.algafood.di.notificacao;
import com.victoralves.algafood.di.modelo.Cliente;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@TipoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmailMock implements Notificador {
    public NotificadorEmailMock(){
        System.out.println("notificador email mock");
    }
    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("MOCK :Notificando seria enviada atraves %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }

}
