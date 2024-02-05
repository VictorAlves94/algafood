package com.victoralves.algafood.jpa.formaPagamento;

import com.victoralves.algafood.AlgafoodApiApplication;
import com.victoralves.algafood.domain.model.FormaPagamento;
import com.victoralves.algafood.domain.repository.FormaPagamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscaFormaPagamentoMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);

        FormaPagamento formaPagamento = formaPagamentoRepository.buscar(1L);

        System.out.println(formaPagamento.getId());
        System.out.println(formaPagamento.getDescricao());
    }

}
