package unit2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ExD {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Mary had a little lamb.".split(" "));

        System.out.println(Util.filter(words, Words.longerThan(3)));
        System.out.println("Expected: [Mary, little, lamb.]");

        System.out.println(Util.filter(words,
                Words.longerThan(3).and(Words.longerThan(5).negate())));
        System.out.println("Expected: [Mary, lamb.]");
    }
}

class Util {
    public static <T> List<T> filter(List<T> values, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T value : values) {
            if (p.test(value)) {
                result.add(value);
            }
        }
        return result;
    }
}