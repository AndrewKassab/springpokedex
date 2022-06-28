package com.andrewpm.pokemon.pokemon;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Move {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
