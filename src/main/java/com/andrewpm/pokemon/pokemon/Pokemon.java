package com.andrewpm.pokemon.pokemon;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
public class Pokemon {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToMany
    @JoinTable(name = "pokemon_moves", joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "move_id"))
    private Set<Move> moves;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    // TODO: Pokemon can only have 4 moves
    public void addMove(Move move) {
        getMoves().add(move);
    }

    @Override
    public String toString() {
        return name;
    }

}
