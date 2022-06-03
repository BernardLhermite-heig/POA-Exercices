package unit2;

import data.Country;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExB {
    public static void main(String[] args) {
        List<Country> countries = Country.getList();

        System.out.println("Smallest Populations");
        Collections.sort(countries, Comparator.comparing(c -> c.getPopulation()));

        for (int i = 0; i < 10; i++)
            System.out.println(countries.get(i));

        System.out.println("\nSmallest Population Densities");
        Collections.sort(countries, Comparator.comparing(c -> c.getPopulation() / c.getArea()));

        for (int i = 0; i < 10; i++)
            System.out.println(countries.get(i));
    }
}
