package com.sistemablogspringboot.servicio.impl;

import com.sistemablogspringboot.dto.PublicacionDTO;
import com.sistemablogspringboot.entidades.Publicacion;
import com.sistemablogspringboot.repositorio.PublicacionRepositorio;
import com.sistemablogspringboot.servicio.PublicacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicacionServicioImpl implements PublicacionServicio {

    @Autowired
    private PublicacionRepositorio publicacionRepositorio;

    @Override
    public PublicacionDTO crearPublicacion(PublicacionDTO publicacionDTO) {

        //Convertimo DTO a entidad
        Publicacion publicacion = new Publicacion();
        publicacion.setTitulo(publicacionDTO.getTitulo());
        publicacion.setDescripcion(publicacionDTO.getDescripcion());
        publicacion.setContenido(publicacionDTO.getContenido());

        Publicacion nuevaPublicacion = publicacionRepositorio.save(publicacion);

        //Convertimos de entidad a DTO
        PublicacionDTO publicacionRespuesta = new PublicacionDTO();

        publicacionRespuesta.setId(nuevaPublicacion.getId());
        publicacionRespuesta.setTitulo(nuevaPublicacion.getTitulo());
        publicacionRespuesta.setContenido(nuevaPublicacion.getContenido());

        return null;
    }
}
