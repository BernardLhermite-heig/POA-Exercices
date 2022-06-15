// Nom :

package oui2;

import oui2.company.*;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class TE2 {
    public static void main(String... args) {
        List<Developer> developers = Data.randomDevs();

        System.out.println("-- 1. Coffee addict :");
        Developer addict = Collections.max(developers, Comparator.comparing(Developer::coffeeConsumption));

        System.out.println(String.format("> %s with %.2f dl.",
                addict.name(), addict.coffeeConsumption() / 100.0));


        System.out.println("\n-- 2. Most fluent developer :");
        Developer mostFluent = Collections.max(developers, Comparator.comparing(new Function<Developer, Integer>() {
            @Override
            public Integer apply(Developer a) {
                return a.skills().size();
            }
        }));

        System.out.println("> " + mostFluent.name());


        System.out.println("\n-- 3. Number of developers knowing 3+ languages");
        long geeks = developers.stream()
                .filter(a -> a.skills().size() >= 3)
                .count();

        System.out.println(String.format("> %d devs", geeks));


        System.out.println("\n-- 4. Cat lovers :");
        String cats = developers.stream()
                .filter(a -> a.hobbies().contains(Hobby.Cats))
                .map(Developer::name)
                .collect(Collectors.joining(", "));

        System.out.println(String.format("> %s", cats.isEmpty() ? "none" : cats));


        System.out.println("\n-- 5. Most hobbies :");
        Developer[] mostHobbies = developers.stream()
                .sorted(Comparator.comparing(a -> a.hobbies().size(), Comparator.reverseOrder()))
                .limit(3)
                .toArray(Developer[]::new);

        for (Developer d : mostHobbies)
            System.out.println("> " + d.name());


        System.out.println("\n-- 6. Total coffee consumption of Java coders");
        int milliliters = developers.stream()
                .filter(a -> a.skills().stream().anyMatch(s -> s.language() == Language.Java))
                .collect(Collectors.summingInt(d -> d.coffeeConsumption()));

        System.out.println(String.format("> %.3f l", milliliters / 1000.0));


        System.out.println("\n-- 7. Number of people knowing each language");

        Map<Language, Integer> devsPerLanguage = new TreeMap<>();
        //developers.forEach(d -> d.skills().forEach(s -> devsPerLanguage.merge(s.language(), 1, (old, newValue) -> old + newValue)));
        developers.forEach(d -> d.skills().forEach(
                s -> devsPerLanguage.merge(s.language(), 1, Integer::sum)
        ));
        devsPerLanguage.forEach((l, nb) -> {
            System.out.println("> " + l + " : " + nb + " devs");
        });

        System.out.println("\n-- 8. Average number of code lines per day");
        double meanLines = averageOf(developers, Developer::skills, Skill::linesOfCodePerDay);

        System.out.println(String.format("> %.2f lines per day", meanLines));
    }

    private static <T, U> double averageOf(List<T> collection,
                                           Function<T, List<U>> listMapper,
                                           ToIntFunction<U> valueMapper) {
        double avg = 0;
        int counter = 0;

        for (T list : collection) {
            for (U e : listMapper.apply(list)) {
                avg += valueMapper.applyAsInt(e);
                ++counter;
            }
        }
        return counter == 0 ? 0 : avg / counter;
    }
}
