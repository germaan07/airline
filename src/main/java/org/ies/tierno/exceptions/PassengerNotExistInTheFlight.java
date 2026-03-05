package org.ies.tierno.exceptions;

public class PassengerNotExistInTheFlight extends Exception {
    private final int numFlight;
    private final String nif;

    public PassengerNotExistInTheFlight(int numFlight, String nif) {
        super("El pasajero " + nif + " no está en el vuelo " + numFlight + ".");
        this.numFlight = numFlight;
        this.nif = nif;
    }
}
