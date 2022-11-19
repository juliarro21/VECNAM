package com.apuestas.Apuestas.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "eventos_equipos")
public class EventTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "evento_id", referencedColumnName = "id")
    private  Event events;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipo_id", referencedColumnName = "id")
    private Team teams;
    public EventTeam() {
    }
    public EventTeam(Event events, Team teams) {
        this.events = events;
        this.teams = teams;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Event getEvents() {
        return events;
    }
    public void setEvents(Event events) {
        this.events = events;
    }
    public Team getTeams() {
        return teams;
    }
    public void setTeams(Team teams) {
        this.teams = teams;
    }
    
    
}
