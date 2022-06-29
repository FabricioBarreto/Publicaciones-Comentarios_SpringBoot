package com.sistemablogspringboot.repositorio;

import com.sistemablogspringboot.entidades.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepositorio extends JpaRepository<Publicacion,Long> {
}
