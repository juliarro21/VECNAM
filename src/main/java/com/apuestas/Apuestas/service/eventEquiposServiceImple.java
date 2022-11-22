package com.apuestas.Apuestas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apuestas.Apuestas.model.EventTeam;
import com.apuestas.Apuestas.repository.EventEquiposRepository;

@Service("eventEquiposService")
public class eventEquiposServiceImple implements EventTeamService {
    @Autowired
    private EventEquiposRepository eventEquiposRepository;
    
        @Override
        public void create(EventTeam eventTeam) {
            eventEquiposRepository.save(eventTeam);
        }
        public List<EventTeam> findByIdEventos(int idEventos) {
            return eventEquiposRepository.findByIdEventos(idEventos);
        }
        public EventTeam findByIdEventAndIdTeams(int idEventos, int idTeams) {
            return eventEquiposRepository.findByIdEventAndIdTeams(idEventos, idTeams);
        }
}
