package com.innocv.multibucket.controllers;

import com.innocv.multibucket.domain.Team;
import com.innocv.multibucket.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping
    public List<Team> getAll() {
        List<Team> all = new ArrayList<>();
        Iterable<Team> iterable = teamRepository.findAll();
        iterable.forEach(all::add);
        return all;
    }

    @PostMapping
    public void create(@RequestBody Team team) {
        teamRepository.save(team);
    }

}
