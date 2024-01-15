package com.victoralves.algafood.di.notificacao;
import com.victoralves.algafood.di.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("development")
@TipoNotificador(NivelUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmailMock implements Notificador {

    @Autowired
    NotificadorProperties properties;
    public NotificadorEmailMock(){
        System.out.println("notificador email mock");
    }
    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.println("Host :" + properties.getHostServidor());
        System.out.println("Porta :" + properties.getPortaServidor());
        System.out.printf("MOCK :Notificando seria enviada atraves %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }

}
