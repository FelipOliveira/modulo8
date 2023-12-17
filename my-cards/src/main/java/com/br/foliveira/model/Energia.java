package com.br.foliveira.model;

import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Energia extends Carta{
    
    public int qtdEnergia;

    public Energia(String nome, Cor cor, int qtdEnergia){
        super(nome, cor);
        this.qtdEnergia = qtdEnergia;
    }

    public Energia(){}
}
