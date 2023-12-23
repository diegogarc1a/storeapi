package com.api.store.exceptions;

public class UsuarioFoundException extends Exception{
    public UsuarioFoundException() {
        super("El usuario con ese username ya existe en la BD");
    }

    public UsuarioFoundException(String message) {
        super(message);
    }
}
