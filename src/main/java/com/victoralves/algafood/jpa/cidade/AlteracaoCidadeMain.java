package com.victoralves.algafood.jpa.cidade;

import com.victoralves.algafood.AlgafoodApiApplication;
import com.victoralves.algafood.domain.model.Cidade;
import com.victoralves.algafood.domain.model.Estado;
import com.victoralves.algafood.domain.repository.CidadeRepository;
import com.victoralves.algafood.domain.repository.EstadoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteracaoCidadeMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
        EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);

        Estado estado = estadoRepository.buscar(1L);




        Cidade cidade = new Cidade();
        cidade.setId(1L);
        cidade.setNome("Nome do estado");
        cidade.setEstado(estado);
        cidadeRepository.salvar(cidade);



        System.out.printf("%d - %s - %s\n", cidade.getId(), cidade.getNome(),cidade.getEstado().getNome());

    }

}
