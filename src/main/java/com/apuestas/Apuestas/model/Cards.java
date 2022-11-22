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
import javax.persistence.Table;

@Entity
@Table(name = "tarjetas")
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "tipo", nullable = false)
    private String tipo;
    @Column(name="numero", nullable = false)
    private int numero;
    @Column(name="nombre_titular")
    private String nombre_titular;
    @Column(name="fecha_vencimiento_mes", nullable = false)
    private int fecha_vencimiento_mes;
    @Column(name="fecha_vencimiento_anio", nullable = false)
    private int fecha_vencimiento_anio;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private  User users;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getFecha_vencimiento_mes() {
        return fecha_vencimiento_mes;
    }
    public void setFecha_vencimiento_mes(int fecha_vencimiento_mes) {
        this.fecha_vencimiento_mes = fecha_vencimiento_mes;
    }
    public int getFecha_vencimiento_anio() {
        return fecha_vencimiento_anio;
    }
    public void setFecha_vencimiento_anio(int fecha_vencimiento_anio) {
        this.fecha_vencimiento_anio = fecha_vencimiento_anio;
    }
    public User getUsers() {
        return users;
    }
    public void setUsers(User users) {
        this.users = users;
    }
    public String getNombre_titular() {
        return nombre_titular;
    }
    public void setNombre_titular(String nombre_titular) {
        this.nombre_titular = nombre_titular;
    }
}
