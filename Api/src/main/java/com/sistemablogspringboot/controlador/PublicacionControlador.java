package com.sistemablogspringboot.controlador;

import com.sistemablogspringboot.dto.PublicacionDTO;
import com.sistemablogspringboot.dto.PublicacionRespuesta;
import com.sistemablogspringboot.servicio.PublicacionServicio;
import com.sistemablogspringboot.utilerias.AppConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionControlador {

    @Autowired
    private PublicacionServicio publicacionServicio;

    @GetMapping
    public PublicacionRespuesta listarPublicaiones(@RequestParam(value = "pageNo", defaultValue = AppConstantes.NUMERO_DE_PAGINAS_POR_DEFECTO,required = false)int numeroPagina,
                                                   @RequestParam(value = "pageSize",defaultValue = AppConstantes.MEDIDA_DE_PAGINA_POR_DEFECTO,required = false)int medidaDePagina,
                                                   @RequestParam(value = "sortBy",defaultValue = AppConstantes.ORDENAR_POR_DEFECTO,required = false)String ordenarPor,
                                                   @RequestParam(value = "sortDir",defaultValue = AppConstantes.ORDENAR_DIRECCION_POR_DEFECTO,required = false)String sortDir){

        return publicacionServicio.obtenerTodasLasPublicaciones( numeroPagina, medidaDePagina,ordenarPor,sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicacionDTO> obtenerPublicacionPorId(@PathVariable long id){
        return ResponseEntity.ok(publicacionServicio.obtenerPublicacionPorId(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<PublicacionDTO> guardarPublicacion(@Valid @RequestBody PublicacionDTO publicacionDTO){

        return new ResponseEntity<>(publicacionServicio.crearPublicacion(publicacionDTO), HttpStatus.CREATED);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PublicacionDTO> actualizarPublicacion(@PathVariable long id,
                                                                @Valid @RequestBody PublicacionDTO publicacionDTO){

        PublicacionDTO publicacionRespuesta = publicacionServicio.actualizarPublicacion(publicacionDTO,id);

        return new ResponseEntity<>(publicacionRespuesta,HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPublicacion(@PathVariable long id){
        publicacionServicio.eliminarPublicacion(id);
        return new ResponseEntity<>("Publicacion eliminada con exito",HttpStatus.OK);
    }


}
