package com.victoralves.algafood.jpa.formaPagamento;

import com.victoralves.algafood.AlgafoodApiApplication;
import com.victoralves.algafood.domain.model.Cozinha;
import com.victoralves.algafood.domain.model.FormaPagamento;
import com.victoralves.algafood.domain.repository.CozinhaRepository;
import com.victoralves.algafood.domain.repository.FormaPagamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoFormaPagamentoMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);



        FormaPagamento pagamento1 = new FormaPagamento();
        pagamento1.setDescricao("Crédito");

        FormaPagamento pagamento2 = new FormaPagamento();
        pagamento2.setDescricao("Débito");

        FormaPagamento pagamento3 = new FormaPagamento();
        pagamento3.setDescricao("Pix");

        FormaPagamento pagamento4 = new FormaPagamento();
        pagamento4.setDescricao("Dinheiro");




        pagamento1 = formaPagamentoRepository.salvar(pagamento1);
        pagamento2 = formaPagamentoRepository.salvar(pagamento2);
        pagamento3 = formaPagamentoRepository.salvar(pagamento3);
        pagamento4 = formaPagamentoRepository.salvar(pagamento4);


        System.out.printf("%d - %s\n", pagamento1.getId(), pagamento1.getDescricao());
        System.out.printf("%d - %s\n", pagamento2.getId(), pagamento2.getDescricao());
        System.out.printf("%d - %s\n", pagamento3.getId(), pagamento3.getDescricao());
        System.out.printf("%d - %s\n", pagamento4.getId(), pagamento4.getDescricao());


    }

}
