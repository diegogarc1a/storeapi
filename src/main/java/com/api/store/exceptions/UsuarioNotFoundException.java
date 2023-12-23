package com.api.store.exceptions;

public class UsuarioNotFoundException extends Exception{

    public UsuarioNotFoundException() {
        super("Usuario con ese username no existe en la BD");
    }

    public UsuarioNotFoundException(String message) {
        super(message);
    }
}
