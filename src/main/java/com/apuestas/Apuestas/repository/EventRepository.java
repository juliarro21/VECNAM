package com.apuestas.Apuestas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apuestas.Apuestas.model.Event;

@Repository("eventRepository")
public interface EventRepository extends JpaRepository<Event, Integer> {
    Event   findByNombre(String nombre);
    List<Event> findAll();
    @Query(value = "SELECT * FROM Event  WHERE Event.id = ?", nativeQuery = true)
    Event findById(int id);
}
