package com.andrewpm.pokemon.exceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(Integer id) {
        super("Could not find entry " + id);
    }

}
