package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Passenger implements Comparable<Passenger>{
    private int nif;
    private int seatNumber;
    private List<Luggage> luggages;


    @Override
    public int compareTo(Passenger passenger) {
        return Integer.compare(seatNumber, passenger.seatNumber);
    }
}
