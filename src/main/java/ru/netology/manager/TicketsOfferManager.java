package ru.netology.manager;
import ru.netology.domain.TicketsOffer;
import ru.netology.repository.TicketsOfferRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketsOfferManager {
    private TicketsOffer[] items = new TicketsOffer[0];
    private TicketsOfferRepository repository;

    public TicketsOfferManager(TicketsOfferRepository repository){
        this.repository = repository;
    }

    public TicketsOffer findByDepartureAirport(String from) {
            for (TicketsOffer item : items) {
                if (item.getFrom().equals(from)) { // if (item.getDepartureAirport() == departureAirport)
                    return item;
                }
            }
            return null;
    }

    public TicketsOffer findByArrivalAirport(String to) {
        for (TicketsOffer item : items) {
            if (item.getTo().equals(to)) {
                return item;
            }
        }
        return null;
    }

    public TicketsOffer[] findAllWithParams(String from, String to) {
        for (TicketsOffer item : items) {
            if (item.getFrom().equals(from)) {
                return items;
            }
            if (item.getTo().equals(to)) {
                return items;
            }
        }
        Arrays.sort(items);
        return items;
    }
}
