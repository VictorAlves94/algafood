 package com.victoralves.algafood.domain.repository;

 import com.victoralves.algafood.domain.model.Restaurante;

 import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> listar();
    Restaurante buscar(Long id);
    Restaurante salvar(Restaurante restaurante);
    void remover(Long restaurante_id);
}
