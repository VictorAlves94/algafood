package com.victoralves.algafood.jpa.Estado;

import com.victoralves.algafood.AlgafoodApiApplication;
import com.victoralves.algafood.domain.model.Estado;
import com.victoralves.algafood.domain.repository.EstadoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoEstadoMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);



        Estado estado1 = new Estado();
        estado1.setNome("Nome do estado aqui");





        estado1 = estadoRepository.salvar(estado1);


        System.out.printf("%d - %s\n", estado1.getId(), estado1.getNome());


    }

}
