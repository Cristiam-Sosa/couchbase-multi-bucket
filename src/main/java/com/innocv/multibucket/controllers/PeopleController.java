package com.innocv.multibucket.controllers;

import com.innocv.multibucket.domain.People;
import com.innocv.multibucket.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @GetMapping
    public List<People> getAll() {
        List<People> all = new ArrayList<>();
        Iterable<People> peopleIterable = peopleRepository.findAll();
        peopleIterable.forEach(all::add);
        return all;
    }

    @PostMapping
    public void create(@RequestBody People people) {
        peopleRepository.save(people);
    }

}
