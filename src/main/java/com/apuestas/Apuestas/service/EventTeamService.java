package com.apuestas.Apuestas.service;
import java.util.List;

import com.apuestas.Apuestas.model.EventTeam;
public interface EventTeamService {
    public void create(EventTeam eventTeam);
    public List<EventTeam> findByIdEventos(int idEventos);
    public EventTeam findByIdEventAndIdTeams(int idEventos, int idTeams);
}

