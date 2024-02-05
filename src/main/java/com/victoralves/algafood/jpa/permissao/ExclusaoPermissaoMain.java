package com.victoralves.algafood.jpa.permissao;

import com.victoralves.algafood.AlgafoodApiApplication;
import com.victoralves.algafood.domain.model.Permissao;
import com.victoralves.algafood.domain.repository.PermissaoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ExclusaoPermissaoMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);

        Permissao permissao = new Permissao();
        permissao.setId(1L);

        permissaoRepository.remover(permissao);


        System.out.printf("%d - %s\n", permissao.getId(), permissao.getNome(), permissao.getDescricao());

    }

}
