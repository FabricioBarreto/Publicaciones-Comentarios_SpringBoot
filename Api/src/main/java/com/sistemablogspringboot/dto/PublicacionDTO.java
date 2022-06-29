package com.sistemablogspringboot.dto;

import com.sistemablogspringboot.entidades.Comentario;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

public class PublicacionDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, message = "El titulo de la publicacion debe ser mayor a 2 Caracteres")
    private String titulo;

    @NotEmpty
    @Size(min = 10, message = "La descripcion de la publicacion debe ser mayor a 10 Caracteres")
    private String descripcion;

    @NotEmpty(message = "El contenido no puede estar vacio")
    private String contenido;

    private Set<Comentario> comentarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public PublicacionDTO(Long id, String titulo, String descripcion, String contenido, Set<Comentario> comentarios) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
        this.comentarios = comentarios;
    }

    public PublicacionDTO() {
        super();
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
