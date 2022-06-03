package unit2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExG {
    public static void main(String[] args) {
        String[] words = "Mary had a little lamb.".split(" ");

        String[] wordsWithA = Util2.filter(words, w -> w.contains("a"), String[]::new);
        System.out.println(Arrays.toString(wordsWithA));
        System.out.println("Expected: [Mary, had, a, lamb.]");

        String[] shortWordsWithA = Util2.filter(wordsWithA,
                w -> w.length() < 4, String[]::new);

        System.out.println(Arrays.toString(shortWordsWithA));
        System.out.println("Expected: [had, a]");

        Integer[] primes = {2, 3, 5, 7, 11, 13, 17};
        Integer[] oddPrimes = Util2.filter(primes,
                n -> n % 2 != 0, Integer[]::new);
        System.out.println(Arrays.toString(oddPrimes));
        System.out.println("Expected: [3, 5, 7, 11, 13, 17]");
    }
}

// TODO: Make this method receive and return an array.
// Accept a constructor expression for constructing the
// returned array.
class Util2 {
    public static <T> T[] filter(T[] values, Predicate<T> p, Function<Integer, T[]> ctor) {
        List<T> result = new LinkedList<>();
        for (T value : values) {
            if (p.test(value)) {
                result.add(value);
            }
        }
        return result.toArray(ctor.apply(result.size()));
    }
}