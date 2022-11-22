package com.apuestas.Apuestas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apuestas.Apuestas.model.EventTeam;

@Repository("eventEquiposRepository")
public interface EventEquiposRepository extends JpaRepository<EventTeam, Integer> {
    @Query(value = "SELECT * FROM eventos_equipos  WHERE eventos_equipos.evento_id = ?", nativeQuery = true)
    List<EventTeam> findByIdEventos(int idEventos);
    @Query(value = "SELECT * FROM eventos_equipos  WHERE eventos_equipos.evento_id = ? AND eventos_equipos.equipo_id = ?", nativeQuery = true)
    public EventTeam findByIdEventAndIdTeams(int idEquipos, int idTeams);
}

