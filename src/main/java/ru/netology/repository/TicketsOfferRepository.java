package ru.netology.repository;
import ru.netology.domain.TicketsOffer;
import ru.netology.manager.TicketsOfferManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketsOfferRepository {
    private TicketsOffer[] items = new TicketsOffer[0];

    public void save(TicketsOffer item) {
        int length = items.length + 1;
        TicketsOffer[] tmp = new TicketsOffer[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public TicketsOffer[] findAll() {
        return items;
    }

    public TicketsOffer[] removeAll() {
        items = new TicketsOffer[0];
        return items;
    }

    public TicketsOffer findById(int id) {
        for (TicketsOffer item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        TicketsOffer[] tmp = new TicketsOffer[length];
        int index = 0;
        for (TicketsOffer item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
