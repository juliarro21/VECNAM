package com.apuestas.Apuestas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apuestas.Apuestas.model.Team;

@Repository("teamRepository")
public interface TeamRepository extends JpaRepository<Team, Integer> {
    Team   findByNombre(String nombre);
    @Query(value = "SELECT * FROM Team  WHERE Team.id = ?", nativeQuery = true)
    Team   findById(int id);
    List<Team> findAll();
}
    

