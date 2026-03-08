package org.ies.tierno.exceptions;

import org.ies.tierno.model.Luggage;

public class InvalidLuggageException extends Exception{
    private final Luggage luggage;

    public InvalidLuggageException(Luggage luggage) {
        super("El Luggage " + luggage.toString() + " es inválido.");
        this.luggage = luggage;
    }
}
