package com.br.foliveira.model;

import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pokemon extends Carta {
    
    public int hp;
    public Estagio estagio;

    public Pokemon(String nome, Cor cor, int hp, Estagio estagio){
        super(nome, cor);
        this.hp = hp;
        this.estagio = estagio;
    }

    public Pokemon(){}
}
