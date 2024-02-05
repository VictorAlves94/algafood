package com.victoralves.algafood.jpa.cidade;

import com.victoralves.algafood.AlgafoodApiApplication;
import com.victoralves.algafood.domain.model.Cidade;
import com.victoralves.algafood.domain.repository.CidadeRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCidadeMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);

        List<Cidade> cidades = cidadeRepository.listar();
        for (Cidade cidade: cidades) {
            System.out.printf("%d - %s - %s\n",cidade.getId(),cidade.getNome(),cidade.getEstado().getNome());
        }

    }
}
