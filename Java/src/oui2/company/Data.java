package oui2.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Data {
    private static final Random rand = new Random(42);

    private static final String[] names = {"Franck", "Stéphane", "Matthieu", "Edouard",
            "Jérémy", "Claire", "Robin", "Loïc", "David", "Clarisse", "Simon", "Thibaud",
            "Gildas", "Frédéric", "Chau Ying", "Elodie", "Soulaymane", "Maurice",
            "Matthieu", "Simon", "Adrian", "Pablo", "Thierry", "Alexandre", "Bastien",
            "Robin", "Alexandre", "Guy-Laurent", "Laurent", "Guillaume Emile", "Simon",
            "Guillaume"
    };

    private static <T> T randomValue(T... values) {
        return values[rand.nextInt(values.length)];
    }

    private static <T> List<T> randomValues(int nbValues, Supplier<T> func) {
        List<T> items = new LinkedList<>();
        for (int i = 0; i < nbValues; ++i)
            items.add(func.get());
        return items;
    }

    private static Language randomLanguage() {
        return randomValue(Language.values());
    }

    private static Hobby randomHobby() {
        return randomValue(Hobby.values());
    }

    private static String randomName() {
        return randomValue(names);
    }


    private static Developer randomDev(int indexName) {
        return new Developer(names[indexName % names.length],
                100 + rand.nextInt(200) + rand.nextInt(400),
                randomValues(rand.nextInt(5) + 1, () -> {
                    return new Skill(randomLanguage(), rand.nextInt(300) + 100 + rand.nextInt(200));
                }),
                randomValues(rand.nextInt(4) + 3, () -> randomHobby()).stream().distinct().collect(Collectors.toList())
        );
    }

    public static List<Developer> randomDevs() {
        List<Developer> devs = new LinkedList<>();
        for (int i = 0; i < names.length; ++i)
            devs.add(randomDev(i));
        return devs;
    }


}
