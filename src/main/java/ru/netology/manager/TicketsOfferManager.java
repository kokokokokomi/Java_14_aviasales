package ru.netology.manager;
import ru.netology.domain.TicketsOffer;
import ru.netology.domain.TicketsOfferComparator;
import ru.netology.repository.TicketsOfferRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
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

    public TicketsOffer[] findAllWithParams(String from, String to, Comparator<TicketsOffer> comparator) {
        for (TicketsOffer item : repository.findAll()) {
            if (item.getFrom().equals(from) && item.getTo().equals(to)) {
                TicketsOffer[] tmp = new TicketsOffer[items.length + 1];
                System.arraycopy(items, 0, tmp, 0, items.length);
                tmp[tmp.length - 1] = item;
                items = tmp;
            }

        }
            Arrays.sort(items, comparator);
            return items;
        }
}
