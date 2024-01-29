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

public class InclusaoRestauranteMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);



        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNome("Mcdonalds");
        restaurante1.setTaxaFrete(BigDecimal.TEN);


        Restaurante restaurante2 = new Restaurante();
        restaurante2.setNome("ChinaInBox");
        restaurante2.setTaxaFrete(BigDecimal.ONE);


        restaurante1 = restauranteRepository.salvar(restaurante1);
        restaurante2 = restauranteRepository.salvar(restaurante2);

        System.out.printf("%d - %s - %.2f\n", restaurante1.getId(), restaurante1.getNome(), restaurante1.getTaxaFrete());
        System.out.printf("%d - %s - %.2f\n", restaurante2.getId(), restaurante2.getNome(), restaurante2.getTaxaFrete());

    }

}
