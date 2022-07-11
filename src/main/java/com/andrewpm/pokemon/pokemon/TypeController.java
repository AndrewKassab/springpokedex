package com.andrewpm.pokemon.pokemon;

import com.andrewpm.pokemon.exceptions.ItemNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class TypeController {

    private final TypeRepository repository;

    TypeController(TypeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/types")
    CollectionModel<EntityModel<Type>> all() {

        List<EntityModel<Type>> types = repository.findAll().stream()
                .map(EntityModel::of) // TODO: Assembler
                .collect(Collectors.toList());

        return CollectionModel.of(types,
                linkTo(methodOn(TypeController.class).all()).withSelfRel());
    }

    @GetMapping("/types/{id}")
    EntityModel<Type> one(@PathVariable Integer id) {
        var type = repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        return EntityModel.of(type);
    }

    @PostMapping("/types")
    ResponseEntity<EntityModel<Type>> newType(@Valid @RequestBody Type type) {
        var newType = repository.save(type);

        return ResponseEntity.created(linkTo(methodOn(TypeController.class).one(newType.getId()))
                .toUri()).body(EntityModel.of(type)); // TODO: Assembler
    }



}
