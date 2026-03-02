package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Airline {
    private String name;
    private Map<Integer, Flight> flightByNumberFlight;
    private List<Client> clients;

    public List<Passenger> getPassengerWithFlightNumber(){
        for (Flight f : flightByNumberFlight.values()){
            if (f.isTheFlight()){

            }
        }
    }
}
