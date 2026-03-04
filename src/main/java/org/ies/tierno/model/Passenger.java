package org.ies.tierno.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
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

    public void showInfo(){
        log.info("CLIENTE: ");
        log.info("NIF: " + nif);
        log.info("Número de Asiento: " + seatNumber);
        log.info("PRENDAS: ");
        for (Luggage l : luggages) {
            l.showInfo();
        }
    }
}
