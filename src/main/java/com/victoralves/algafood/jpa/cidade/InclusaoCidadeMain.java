package com.victoralves.algafood.jpa.cidade;

import com.victoralves.algafood.AlgafoodApiApplication;
import com.victoralves.algafood.domain.model.Cidade;
import com.victoralves.algafood.domain.model.Estado;
import com.victoralves.algafood.domain.repository.CidadeRepository;
import com.victoralves.algafood.domain.repository.EstadoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

    public class InclusaoCidadeMain {
        public static void main(String[] args) {
            ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                    .web(WebApplicationType.NONE)
                    .run(args);

            CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
            EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);

            Estado estado = estadoRepository.buscar(1L);



            Cidade cidade1 = new Cidade();
            cidade1.setNome("Gama");
            cidade1.setEstado(estado);





            cidade1 = cidadeRepository.salvar(cidade1);


            System.out.printf("%d - %s - %s\n", cidade1.getId(), cidade1.getNome(), cidade1.getEstado().getNome());


        }

    }

