package com.victoralves.algafood.jpa.formaPagamento;

import com.victoralves.algafood.AlgafoodApiApplication;
import com.victoralves.algafood.domain.model.Cozinha;
import com.victoralves.algafood.domain.model.FormaPagamento;
import com.victoralves.algafood.domain.repository.CozinhaRepository;
import com.victoralves.algafood.domain.repository.FormaPagamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteracaoFormaPagamentoMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);




        FormaPagamento pagamento = new FormaPagamento();
        pagamento.setId(1L);
        pagamento.setDescricao("Cartao de Credito");
        formaPagamentoRepository.salvar(pagamento);



        System.out.printf("%d - %s\n", pagamento.getId(), pagamento.getDescricao());

    }

}
