package com.victoralves.algafood.di.notificacao;

import com.victoralves.algafood.di.modelo.Cliente;

public interface Notificador {
   void notificar(Cliente cliente, String msg);
}
