package com.apuestas.Apuestas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apuestas.Apuestas.model.Team;
import com.apuestas.Apuestas.repository.TeamRepository;
@Service("teamService")
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Override
    public Team findByNombre(String nombre) {
        return teamRepository.findByNombre(nombre);
    }
    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }
    @Override
    public Team findById(int id) {
        return teamRepository.findById(id);
    }
    
}
    

