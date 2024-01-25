package com.victoralves.algafood.jpa;

import com.victoralves.algafood.AlgafoodApiApplication;
import com.victoralves.algafood.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);



        System.out.println("Criando cozinha Brasileira");
        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("Brasileira");

        System.out.println("Criando cozinha Japonesa");
        Cozinha cozinha2 = new Cozinha();
        cozinha2.setNome("Japonesa");

        System.out.println("Gravando cozinha Brasileira");
        cadastroCozinha.adicionar(cozinha1);


        System.out.println("Gravando cozinha Japonesa");
        cozinha2 = cadastroCozinha.adicionar(cozinha2);

        System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
        System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());

    }

}
