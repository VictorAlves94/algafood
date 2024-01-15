package com.victoralves.algafood.di.notificacao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("notificador.email")
public class NotificadorProperties {
    /**
     * Host do servidor de email
     */
    private String hostServidor;
    /**
     * Porta de servidor de email
     */
    private  Integer portaServidor = 25;
}
