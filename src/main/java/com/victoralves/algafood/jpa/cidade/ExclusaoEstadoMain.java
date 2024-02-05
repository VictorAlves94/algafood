package com.victoralves.algafood.jpa.cidade;

import com.victoralves.algafood.AlgafoodApiApplication;
import com.victoralves.algafood.domain.model.Cidade;
import com.victoralves.algafood.domain.model.Estado;
import com.victoralves.algafood.domain.repository.CidadeRepository;
import com.victoralves.algafood.domain.repository.EstadoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ExclusaoEstadoMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);

        Cidade cidade = new Cidade();
        cidade.setId(1L);

        cidadeRepository.remover(cidade);


        System.out.printf("%d - %s\n", cidade.getId(), cidade.getNome(), cidade.getEstado().getNome());

    }

}
