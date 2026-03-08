package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ies.tierno.exceptions.FlightNotFoundByNumFlight;
import org.ies.tierno.exceptions.InvalidLuggageException;
import org.ies.tierno.exceptions.InvalidLuggageIdExceeption;
import org.ies.tierno.exceptions.PassengerNotExistInTheFlight;

import java.util.ArrayList;
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

    public List<Client> getClientsPassengers(int numFlight) throws FlightNotFoundByNumFlight {
        Flight f = findFlight(numFlight);
        List<Passenger> passengers = getPassengerWithFlightNumber(numFlight);
        List<Client> clientsAndPassenger = new ArrayList<>();
        for (Passenger p : passengers){
            for (Client c : clients){
                if (c.getNif().equals(p.getNif())){
                    clientsAndPassenger.add(c);
                }
            }
        }
        return clientsAndPassenger;
    }

    public Integer getSeat(int numFlight, String nif) throws FlightNotFoundByNumFlight, PassengerNotExistInTheFlight {
        return findFlight(numFlight).getPassenger(numFlight, nif).getSeatNumber();
    }

    public boolean addLuggage(int numFlight, String nif, Luggage luggage) throws InvalidLuggageException, InvalidLuggageIdExceeption, FlightNotFoundByNumFlight, PassengerNotExistInTheFlight {
        return findFlight(numFlight).getPassenger(numFlight, nif).addLuggage(luggage);
    }

    //Dado un nif, devuelve los vuelos en los que ese cliente es pasajero.



}
