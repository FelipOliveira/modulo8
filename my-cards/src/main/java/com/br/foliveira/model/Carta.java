package com.br.foliveira.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Carta extends PanacheEntity{

    protected String nome;
    protected Cor cor;

    Carta(String nome, Cor cor){
        this.nome = nome;
        this.cor = cor;
    }
}
