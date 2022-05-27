package com.gerardo.actividadback1.entidades;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "CATEGORIA")
@ApiModel(description = "Data de la Categoria")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CAT")
    @ApiModelProperty(value = "ID de la categoria")
    private long id;
    
    @Column(name = "CAT_NOMBRE")
    @ApiModelProperty(value = "nombre de la categoria")
    private String nombre;

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
