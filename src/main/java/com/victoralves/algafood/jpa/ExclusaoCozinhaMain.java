package com.victoralves.algafood.jpa;

import com.victoralves.algafood.AlgafoodApiApplication;
import com.victoralves.algafood.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ExclusaoCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

        Cozinha cozinha = new Cozinha();
        cozinha.setId(1L);

        cadastroCozinha.remove(cozinha);


        System.out.printf("%d - %s\n", cozinha.getId(), cozinha.getNome());

    }

}
