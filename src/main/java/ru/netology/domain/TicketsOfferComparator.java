package ru.netology.domain;

import ru.netology.repository.TicketsOfferRepository;

import java.util.Comparator;

public class TicketsOfferComparator implements Comparator<TicketsOffer> {
    public int compare(TicketsOffer o1, TicketsOffer o2) {
        return o1.getTimeInFlight() - o2.getTimeInFlight();
    }
    private TicketsOfferRepository repository;

    public TicketsOfferComparator(TicketsOfferRepository repository){
        this.repository = repository;
    }
}
