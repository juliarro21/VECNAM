package com.apuestas.Apuestas.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "apuestas")
public class Bets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User users;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_evento_equipo", referencedColumnName = "id")
    private EventTeam eventos_equipos;
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public User getUsers() {
        return users;
    }
    public void setUsers(User users) {
        this.users = users;
    }
    public EventTeam getEventos_equipos() {
        return eventos_equipos;
    }
    public void setEventos_equipos(EventTeam eventos_equipos) {
        this.eventos_equipos = eventos_equipos;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
