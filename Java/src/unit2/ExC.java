package unit2;

import java.util.Arrays;
import java.util.Comparator;

public class ExC {
    public static void main(String[] args) {
        String[] words = "Mary had a little lamb.".split(" ");
        Comparator<String> c1 = (a, b) -> a.compareToIgnoreCase(b);
        Comparator<String> c2 = Comparator.comparing(s -> s.length());
        Arrays.sort(words, Comparators.reverse(c1));
        System.out.println(Arrays.toString(words));
        System.out.println("Expected: [Mary, little, lamb., had, a]");
        Arrays.sort(words, Comparators.reverse(c2));
        System.out.println(Arrays.toString(words));
        System.out.println("Expected: [little, lamb., Mary, had, a]");
    }
}


class Comparators {
    public static <T> Comparator<T> reverse(Comparator<T> comp) {
        return (a, b) -> comp.compare(b, a);
    }
}