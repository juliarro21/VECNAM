package com.apuestas.Apuestas.service;

import java.util.List;


import com.apuestas.Apuestas.model.Event;

public interface EventService {
     
     public Event findByNombre(String nombre);
     public Event findById(int id);
     public  List<Event>  findAll();
     public void create(Event event);
     public void editar(Event event);
}
