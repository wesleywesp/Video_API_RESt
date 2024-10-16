package com.Wesleywesp.Videos_APi_REST.infra.exception;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException(String mensagem) {
        super(mensagem);
    }
}
