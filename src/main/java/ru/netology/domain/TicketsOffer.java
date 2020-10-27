package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class TicketsOffer implements Comparable<TicketsOffer> {
    private int id; // 1, 2, 3
    private int price; // 3483, 3803, 5773
    private String departureAirport; //SCW
    private String arrivalAirport; //VKO
    private int timeInFlight; // 60, 65, 65

    @Override
    public int compareTo(TicketsOffer o) {
        return 0;
    }
}
