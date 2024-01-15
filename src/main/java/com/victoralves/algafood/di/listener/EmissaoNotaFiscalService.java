package com.victoralves.algafood.di.listener;

import com.victoralves.algafood.di.service.ClienteAtivadoEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmissaoNotaFiscalService {
    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event){
        System.out.println("Emitindo Nota fiscal para cliente" + event.getCliente().getNome());
    }
}
