package com.victoralves.algafood.jpa.Estado;

import com.victoralves.algafood.AlgafoodApiApplication;
import com.victoralves.algafood.domain.model.Estado;
import com.victoralves.algafood.domain.repository.EstadoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteracaoEstadoMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);




        Estado estado = new Estado();
        estado.setId(1L);
        estado.setNome("Nome do estado");
        estadoRepository.salvar(estado);



        System.out.printf("%d - %s\n", estado.getId(), estado.getNome());

    }

}
