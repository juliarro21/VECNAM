package com.apuestas.Apuestas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apuestas.Apuestas.model.Event;
import com.apuestas.Apuestas.model.EventTeam;
import com.apuestas.Apuestas.repository.EventRepository;
import com.apuestas.Apuestas.repository.TeamRepository;

@Service("eventService")
public class EventServiceImpl  implements EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventTeamService eventEquiposService;
    @Autowired
    private TeamRepository teamRepository;
     
    EventTeam eventEquipos;
    @Autowired TeamService teamService;
    @Override
    public Event findByNombre(String nombre) {
        return eventRepository.findByNombre(nombre);
    }
    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }
    @Override
    public Event findById(int id) {
        return eventRepository.findById(id);
    }
    @Override
    public void create(Event event) {
        
            event.setGanador(0);
            eventRepository.save(event);
            eventEquipos=new EventTeam(event,teamRepository.findById(event.getEquipo1()));
            eventEquiposService.create(eventEquipos);
            eventEquipos=new EventTeam(event,teamRepository.findById(event.getEquipo2()));
            eventEquiposService.create(eventEquipos);
        }
    @Override
    public void editar(Event event) {
        eventRepository.save(event);
    }
    }
    

    

