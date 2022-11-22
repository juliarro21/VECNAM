package com.apuestas.Apuestas.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.EnumType;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name ="cedula", nullable = false)
    private Integer cedula;
    @Column(name = "fecha_nacimiento", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fecha_nacimiento;
    @Column(name = "genero", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GeneroTipo genero;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @Column(name = "usuario", nullable = false)
    private String usuario;
    @Column(name = "contrasena", nullable = false)
    private String contrasena;
    @Column(name = "active", nullable = false)
    private int active;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getCedula() {
        return cedula;
    }
    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha) {
        Date date=null;
        try {
            date = (Date) new SimpleDateFormat("yyyy-mm-dd").parse(fecha);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.fecha_nacimiento = date;
    }
    public GeneroTipo getGenero() {
        return genero;
    }
    public void setGenero(GeneroTipo genero) {
        this.genero = genero;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public int getActive() {
        return active;
       }
      
       public void setActive(int active) {
        this.active = active;
       }
      
}
