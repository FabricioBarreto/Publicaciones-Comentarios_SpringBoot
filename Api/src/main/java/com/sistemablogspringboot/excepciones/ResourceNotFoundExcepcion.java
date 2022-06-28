package com.sistemablogspringboot.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcepcion extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String nombreDelRecurso;

    private String nombreDelCampo;

    private long valorDelCampo;

    public ResourceNotFoundExcepcion(String nombreDelRecurso, String nombreDelCampo, long valorDelCampo) {
        super(String.format("%s No encontrado con : %s : ''",nombreDelRecurso,nombreDelCampo,valorDelCampo));
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }

    public ResourceNotFoundExcepcion(String message, String nombreDelRecurso, String nombreDelCampo, long valorDelCampo) {
        super(message);
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }

    public ResourceNotFoundExcepcion(String message, Throwable cause, String nombreDelRecurso, String nombreDelCampo, long valorDelCampo) {
        super(message, cause);
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }

    public ResourceNotFoundExcepcion(Throwable cause, String nombreDelRecurso, String nombreDelCampo, long valorDelCampo) {
        super(cause);
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }

    public ResourceNotFoundExcepcion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String nombreDelRecurso, String nombreDelCampo, long valorDelCampo) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }

    public String getNombreDelRecurso() {
        return nombreDelRecurso;
    }

    public void setNombreDelRecurso(String nombreDelRecurso) {
        this.nombreDelRecurso = nombreDelRecurso;
    }

    public String getNombreDelCampo() {
        return nombreDelCampo;
    }

    public void setNombreDelCampo(String nombreDelCampo) {
        this.nombreDelCampo = nombreDelCampo;
    }

    public long getValorDelCampo() {
        return valorDelCampo;
    }

    public void setValorDelCampo(long valorDelCampo) {
        this.valorDelCampo = valorDelCampo;
    }
}
