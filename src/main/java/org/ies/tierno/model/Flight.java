package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

@Data
@AllArgsConstructor
public class Flight {
    private int flightNumber;
    private String origin;
    private String destination;
    private LocalDate flightDate;
    private TreeSet<Passenger> passengersBySeatNumber;

    public boolean isTheFlight(int numFlighr){
        if (numFlighr == flightNumber){
            return true;
        }
        return false;
    }

    public List<Passenger> getPassengers(){
        return new ArrayList<>(passengersBySeatNumber);
    }


}
