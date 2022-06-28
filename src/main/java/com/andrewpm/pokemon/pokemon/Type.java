package com.andrewpm.pokemon.pokemon;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moves")
@Getter
public class Type {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

}
