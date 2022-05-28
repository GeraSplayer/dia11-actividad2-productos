package com.gerardo.actividadback1.entidades;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "PRODUCTO")
@ApiModel(description = "Data del producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    @ApiModelProperty(value = "ID del producto")
    private long id;

    @Column(name = "PRO_NOMBRE")
    @ApiModelProperty(value = "Nombre del producto")
    private String nombre;

    @Column(name = "PRO_DESCRIPCION")
    @ApiModelProperty(value = "descripcion del producto")
    private String descripcion;

    @Column(name = "PRO_PRECIO")
    @ApiModelProperty(value = "numero del producto")
    private long numero;

    @Column(name = "PRO_CATEGORIA")
    @ApiModelProperty(value = "ID de la categoria del producto")
    private long categoria_id;

    public long getId() {
        return id;
    }public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public long getNumero() {
        return numero;
    }
    public void setNumero(long numero) {
        this.numero = numero;
    }
    public long getCategoria_id() {
        return categoria_id;
    }
    public void setCategoria_id(long categoria_id) {
        this.categoria_id = categoria_id;
    }
}
