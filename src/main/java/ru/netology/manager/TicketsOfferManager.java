package ru.netology.manager;
import ru.netology.domain.TicketsOffer;
import ru.netology.repository.TicketsOfferRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketsOfferManager {
    private TicketsOffer[] items = new TicketsOffer[0];

    public TicketsOffer findByDepartureAirport(String departureAirport) {
            for (TicketsOffer item : items) {
                if (item.getDepartureAirport() == departureAirport) {
                    return item;
                }
            }
            return null;
    }

    public TicketsOffer findByArrivalAirport(String arrivalAirport) {
        for (TicketsOffer item : items) {
            if (item.getArrivalAirport() == arrivalAirport) {
                return item;
            }
        }
        return null;
    }
}
