package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ies.tierno.exceptions.FlightNotFoundByNumFlight;
import org.ies.tierno.exceptions.InvalidLuggageException;
import org.ies.tierno.exceptions.PassengerNotExistInTheFlight;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Data
@AllArgsConstructor
public class Airline {
    private String name;
    private Map<Integer, Flight> flightByNumberFlight;
    private List<Client> clients;

    private boolean existFlight(int numFlight){
        return flightByNumberFlight.containsKey(numFlight);
    }

    public Flight findFlight(int numFlight) throws FlightNotFoundByNumFlight {
        if (existFlight(numFlight)){
            return flightByNumberFlight.get(numFlight);
        }
        throw new FlightNotFoundByNumFlight(numFlight);
    }

    public List<Passenger> getPassengerWithFlightNumber(int numFlight) throws FlightNotFoundByNumFlight {
        return findFlight(numFlight).getPassengers();
    }


    public List<Client> getClientsPassengers(int numFlight) throws FlightNotFoundByNumFlight {
        var passengersNif = getPassengerWithFlightNumber(numFlight).stream()
                .map(Passenger::getNif)
                .collect(Collectors.toSet());

        return clients.stream()
                .filter(client -> passengersNif.contains(client.getNif()))
                .toList();
    }

    public List<Client> getClientsBySurname(String surname) {
        return clients.stream()
                .filter(client -> client.getSurname().equals(surname))
                .toList();
    }

    public Integer getSeat(int numFlight, String nif) throws FlightNotFoundByNumFlight, PassengerNotExistInTheFlight {
        return findFlight(numFlight).getPassenger(numFlight, nif).getSeatNumber();
    }

    public boolean addLuggage(int numFlight, String nif, Luggage luggage) throws InvalidLuggageException, FlightNotFoundByNumFlight, PassengerNotExistInTheFlight {
        return findFlight(numFlight).getPassenger(numFlight, nif).addLuggage(luggage);
    }

    public List<Flight> getClientsFlights(String nif){
        return flightByNumberFlight.values().stream()
                .filter(f -> f.getPassengersBySeatNumber().stream()
                        .anyMatch(passenger -> passenger.getNif().equals(nif)))
                .toList();
    }
}
