package org.ies.tierno.exceptions;

public class InvalidLuggageIdExceeption extends Exception{
    private String id;

    public InvalidLuggageIdExceeption(String id) {
        super("El ID " + id + " del Luggage es inválido.");
        this.id = id;
    }
}
