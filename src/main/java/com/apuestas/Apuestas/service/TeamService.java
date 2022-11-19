package com.apuestas.Apuestas.service;

import org.springframework.data.jpa.repository.Query;

public interface TeamService {
    public com.apuestas.Apuestas.model.Team findByNombre(String nombre);
    @Query(value = "SELECT * FROM Team  WHERE Team.id = ?", nativeQuery = true)
    public com.apuestas.Apuestas.model.Team findById(int id);
    public java.util.List<com.apuestas.Apuestas.model.Team> findAll();
    
}
