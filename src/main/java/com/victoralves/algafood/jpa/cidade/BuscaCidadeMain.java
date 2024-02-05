package com.victoralves.algafood.jpa.cidade;

import com.victoralves.algafood.AlgafoodApiApplication;
import com.victoralves.algafood.domain.model.Cidade;
import com.victoralves.algafood.domain.repository.CidadeRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscaCidadeMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CidadeRepository cidadeRepositoryRepository = applicationContext.getBean(CidadeRepository.class);

        Cidade cidade = cidadeRepositoryRepository.buscar(1L);

            System.out.printf("%d - %s - %s \n",cidade.getId(),cidade.getNome(), cidade.getEstado().getNome());
        }

}
