package com.victoralves.algafood.jpa.restaurante;

import com.victoralves.algafood.AlgafoodApiApplication;
import com.victoralves.algafood.domain.model.Cozinha;
import com.victoralves.algafood.domain.model.Restaurante;
import com.victoralves.algafood.domain.repository.CozinhaRepository;
import com.victoralves.algafood.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public class AlteracaoRestauranteMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);




        Restaurante restaurante = new Restaurante();
        restaurante.setId(1L);
        restaurante.setNome("Brasileira");
        restaurante.setTaxaFrete(BigDecimal.TEN);
        restauranteRepository.salvar(restaurante);



        System.out.printf("%d - %s\n", restaurante.getId(), restaurante.getNome());

    }

}
