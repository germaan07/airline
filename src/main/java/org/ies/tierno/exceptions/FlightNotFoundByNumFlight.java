package org.ies.tierno.exceptions;

public class FlightNotFoundByNumFlight extends Exception {
    private final int flightNumber;

    public FlightNotFoundByNumFlight(int flightNumber) {
        super("No se ha encontrado el vuelo: " + flightNumber);
        this.flightNumber = flightNumber;
    }
}