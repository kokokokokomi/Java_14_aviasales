package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class TicketsOffer implements Comparable<TicketsOffer> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int timeInFlight;

    @Override
    public int compareTo(TicketsOffer o) {
        return price - o.price;
    }
}
