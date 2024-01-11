package com.victoralves.algafood.di.notificacao;

import com.victoralves.algafood.di.modelo.Cliente;

public class NotificadorEmail implements Notificador {

    private boolean caixaAlta;
    private String hotstServidorSmtp;



    public NotificadorEmail(String hotstServidorSmtp) {
        this.hotstServidorSmtp = hotstServidorSmtp;

        System.out.println("NotificadorEmail");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem) {
       if(this.caixaAlta){
           mensagem.toUpperCase();
       }

        System.out.printf("Notificando %s através do e-mail %s usando SMTP %s: %s\n",
                cliente.getNome(), cliente.getEmail(),this.hotstServidorSmtp, mensagem);
    }

    public void setCaixaAlta(boolean caixaAlta) {
        this.caixaAlta = caixaAlta;
    }
}
