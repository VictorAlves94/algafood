package com.victoralves.algafood.di.service;

import com.victoralves.algafood.di.modelo.Cliente;

public class ClienteAtivadoEvent {
    private Cliente cliente;

            public ClienteAtivadoEvent(Cliente cliente){
                super();
                this.cliente = cliente;
            }

    public Cliente getCliente() {
        return cliente;
    }
}
