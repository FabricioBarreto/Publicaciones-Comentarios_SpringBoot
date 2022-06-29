package com.sistemablogspringboot.controlador;

import com.sistemablogspringboot.dto.ComentarioDTO;
import com.sistemablogspringboot.servicio.ComentarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ComentarioControlador {

    @Autowired
    ComentarioServicio comentarioServicio;

    @GetMapping("/publicaciones/{publicacionId}/comentarios")
    public List<ComentarioDTO> listarComentariosPorPublicacion(@PathVariable(value = "publicacionId")Long publicacionId) {
        return comentarioServicio.obtenerComentariosPorPublicacionId(publicacionId);
    }

    @GetMapping("/publicaciones/{publicacionId}/comentarios/{comentarioId}")
    public ResponseEntity<ComentarioDTO> obtenerComentarioPorId(@PathVariable(value = "publicacionId")Long publicacionId,
                                                                @PathVariable(value = "comentarioId")Long comentarioId) {

        ComentarioDTO comentarioDTO = comentarioServicio.obtenerComentarioPorId(publicacionId,comentarioId);

        return new ResponseEntity<>(comentarioDTO,HttpStatus.OK);
    }

    @PostMapping("/publicaciones/{publicacionId}/comentarios")
    public ResponseEntity<ComentarioDTO> guardarComentario(@PathVariable(value = "publicacionId")Long publicacionId,
                                                           @Valid @RequestBody ComentarioDTO comentarioDTO) {
        return new ResponseEntity<>(comentarioServicio.crearComentario(publicacionId,comentarioDTO), HttpStatus.CREATED);
    }

    @PutMapping("/publicaciones/{publicacionId}/comentarios/{comentarioId}")
    public ResponseEntity<ComentarioDTO> actualizarComentario(@PathVariable(value = "publicacionId")Long publicacionId,
                                                              @PathVariable(value = "comentarioId")Long comentarioId,
                                                              @Valid @RequestBody ComentarioDTO comentarioDTO) {
        ComentarioDTO comentarioActualizado = comentarioServicio.actualizarComentario(publicacionId,comentarioId,comentarioDTO);

        return new ResponseEntity<>(comentarioActualizado,HttpStatus.OK);
    }

    @DeleteMapping("/publicaciones/{publicacionId}/comentarios/{comentarioId}")
    public ResponseEntity<String> eliminarComentario(@PathVariable(value = "publicacionId")Long publicacionId,
                                                     @PathVariable(value = "comentarioId")Long comentarioId){
            comentarioServicio.eliminarComentario(publicacionId,comentarioId);
            return new ResponseEntity<>("Comentario elimado con exito",HttpStatus.OK);
    }

}
