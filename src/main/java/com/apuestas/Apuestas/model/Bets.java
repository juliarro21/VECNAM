package com.apuestas.Apuestas.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "apuestas")
public class Bets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private Set<User> users;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_evento_equipo", referencedColumnName = "id")
    private EventTeam eventos_equipos;
    @Column(name = "cantidad", nullable = false)
    private int cantidad;

}
