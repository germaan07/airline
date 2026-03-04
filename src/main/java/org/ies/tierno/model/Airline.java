package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ies.tierno.exceptions.FlightNotFoundByNumFlight;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Airline {
    private String name;
    private Map<Integer, Flight> flightByNumberFlight;
    private List<Client> clients;

    public Flight findFlight(int numFlight) throws FlightNotFoundByNumFlight {
        for (Flight f : flightByNumberFlight.values()){
            if (f.isTheFlight(numFlight)){
                return f;
            }
        }
        throw new FlightNotFoundByNumFlight(numFlight);
    }

    public List<Passenger> getPassengerWithFlightNumber(int numFlight) throws FlightNotFoundByNumFlight {
        return findFlight(numFlight).getPassengers();
    }
    //Dado un número de vuelo, devuelve los clientes que son pasajeros en el vuelo.

    public Client getClientsPassengers(int numFlight) throws FlightNotFoundByNumFlight {
        Flight f = findFlight(numFlight);
        List<Passenger> passengers = getPassengerWithFlightNumber(numFlight);
        for ()
    }
}
