package com.apuestas.Apuestas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GenerationType;

@Entity
@Table(name = "event")
public class Event{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @DateTimeFormat(pattern="HH:MM")
    @Column(name = "hora", nullable = false)
    private Time hora;
    @Column(name = "ganador", nullable = true)
    private int ganador;
    private int equipo1;
    private int equipo2;
    public Event() {}
    public Event(String nombre, Date fecha, Time hora) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public Date getFecha() {
        return fecha;
    }
    public Time getHora() {
        return hora;
    }
    public int getGanador() {
        return ganador;
    }
    public void setFecha(String fecha) {
        Date date=null;
        try {
            date = new SimpleDateFormat("yyyy-mm-dd").parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.fecha = date;
    }
    public void setHora(String hora) {
        this.hora = Time.valueOf(hora+":00");

    }
    public void setGanador(int ganador) {
        this.ganador = ganador;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEquipo1() {
        return equipo1;
    }
    public void setEquipo1(int equipo1) {
        this.equipo1 = equipo1;
    }
    public int getEquipo2() {
        return equipo2;
    }
    public void setEquipo2(int equipo2) {
        this.equipo2 = equipo2;
    }
}

