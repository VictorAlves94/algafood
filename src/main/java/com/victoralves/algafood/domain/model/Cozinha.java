package com.victoralves.algafood.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tab_cozinhas")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Cozinha {
    @Id
    private Long id;

    @Column(name="nome_cozinha")
    private String nome;


}
