package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.TicketsOfferManager;
import ru.netology.repository.TicketsOfferRepository;

import java.util.Arrays;

class TicketsOfferTest {
    TicketsOfferRepository repository = new TicketsOfferRepository();
    TicketsOfferManager manager = new TicketsOfferManager(repository);

    private TicketsOffer first = new TicketsOffer(1, 1299, "SVO", "KZN", 95);
    private TicketsOffer second = new TicketsOffer(2, 2199, "VKO", "KZN", 100);
    private TicketsOffer third = new TicketsOffer(3, 3483, "SCW", "VKO", 65);
    private TicketsOffer fourth = new TicketsOffer(4, 5000, "SCW", "SVO", 70);
    private TicketsOffer fifth = new TicketsOffer(5, 4500, "SVO", "SCW", 75);
    private TicketsOffer sixth = new TicketsOffer(6, 2000, "SVO", "KZN", 100);

    @Test
    public void shouldSortByPrice() {
        TicketsOffer[] expected = new TicketsOffer[]{first, second, third};
        TicketsOffer[] actual = new TicketsOffer[]{first, second, third};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
    }

    @Test
    public void shouldFindAllWithParams1(){
        TicketsOffer[] expected = manager.findAllWithParams("SCW", "VKO");
        TicketsOffer[] actual = new TicketsOffer[]{third};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    public void shouldFindAllWithParams2(){
        TicketsOffer[] expected = manager.findAllWithParams("SVO", "KZN");
        TicketsOffer[] actual = new TicketsOffer[]{first, sixth};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test void shouldFindAllWithParamsIfNotExist(){
        TicketsOffer[] expected = manager.findAllWithParams("VKO", "SCW");
        TicketsOffer[] actual = new TicketsOffer[]{null};
        assertArrayEquals(expected, actual);
    }

    @Test void shouldFindAllWithParamsIfSameDestination(){
        TicketsOffer[] expected = manager.findAllWithParams("VKO", "VKO");
        TicketsOffer[] actual = new TicketsOffer[]{null};
        assertArrayEquals(expected, actual);
    }

}