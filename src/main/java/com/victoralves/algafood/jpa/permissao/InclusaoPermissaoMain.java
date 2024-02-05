package com.victoralves.algafood.jpa.permissao;

import com.victoralves.algafood.AlgafoodApiApplication;
import com.victoralves.algafood.domain.model.Cozinha;
import com.victoralves.algafood.domain.model.Permissao;
import com.victoralves.algafood.domain.repository.CozinhaRepository;
import com.victoralves.algafood.domain.repository.PermissaoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoPermissaoMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);



        Permissao permissao1 = new Permissao();
        permissao1.setNome("Estoque");
        permissao1.setDescricao("Este usuario tem permissao para adcionar ou retirar do estoque");

        Permissao permissao2 = new Permissao();
        permissao1.setNome("Entrega");
        permissao1.setDescricao("Este usuario tem permissao para realizar entregas");




        permissao1 = permissaoRepository.salvar(permissao1);
        permissao2 = permissaoRepository.salvar(permissao2);


        System.out.printf("%d - %s\n", permissao1.getId(), permissao1.getNome(), permissao1.getDescricao());
        System.out.printf("%d - %s\n", permissao2.getId(), permissao2.getNome(), permissao2.getDescricao());

    }

}
