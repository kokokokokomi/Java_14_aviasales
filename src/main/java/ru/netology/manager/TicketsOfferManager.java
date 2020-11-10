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

    //public TicketsOffer[] getAll() {
    //    TicketsOffer[] items = repository.findAll();
    //    TicketsOffer[] result = new TicketsOffer[items.length];
    //    for (int i = 0; i < result.length; i++) {
    //        int index = items.length - i - 1;
    //        result[i] = items[index];
    //    }
    //    return result;
    //}

    public TicketsOffer[] findAllWithParams(String from, String to) {
        //for (TicketsOffer item : items)//
        for (TicketsOffer item : repository.findAll()) {
            if (item.getFrom().equals(from) && item.getTo().equals(to)) {
                TicketsOffer[] tmp = new TicketsOffer[items.length + 1];
                System.arraycopy(items, 0, tmp, 0, items.length);
                tmp[tmp.length - 1] = item;
                items = tmp;
            }

        }
        Arrays.sort(items);
        return items;
    }
}
