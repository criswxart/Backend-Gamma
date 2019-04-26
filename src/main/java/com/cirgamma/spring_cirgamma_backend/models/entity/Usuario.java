package com.cirgamma.spring_cirgamma_backend.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="usuario") //si es que el nombre de la clase es igual a la tabla de la BD se omite, al contrario se puede cambiar
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    //@Column(nullable=false)
    @NotEmpty
    @Size(min = 3, max = 15)
    private String nombre;
    @NotEmpty
    private String apellidos;
    @NotEmpty
    private String direccion;
    //@Column(nullable=false, unique=true)
    private String telefono;

    @NotNull
    @Column(name="fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;

    /* Si queremos guardar la fecha actual al momento de la inserción
    @PrePersist
    public void prePersist(){
        fechaNac = new Date();
    }
     */


    public Long getId() {
        return id;
    }

    public void setIdUsuario(Long idUsuario) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    private static final long serialVersionUID = 1L;

}