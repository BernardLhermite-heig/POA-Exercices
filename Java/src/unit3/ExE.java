package unit3;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExE {
    List<Pair<String, Long>> wordsWithManyVowels(Stream<String> words, int n) {
        return words.map(w -> Pair.of(w, (Words2.vowels(w) - (w.length() - Words2.vowels(w)))))
                //                              v peut pas inférer ce gros con
                .sorted(Comparator.comparing((Pair<String, Long>::second)) // nice cock
//                                                v pour les plus fragiles d'entre vous
//                .sorted(Comparator.comparing((Pair<String, Long> stringLongPair) -> stringLongPair.second())
                        .reversed()
                        .thenComparing(Pair::first))
                .limit(n)
                .collect(Collectors.toList());
    }
}

class Words2 {
    public static long vowels(String str) {
        return 0; // ntm j'ai pas le code
    }
}

class Pair<T, S> {
    private T first;
    private S second;

    public Pair(T firstElement, S secondElement) {
        first = firstElement;
        second = secondElement;
    }

   /*
      Use Pair.of(x, y) instead of new Pair<...,...>(x, y)
      so you get the type inferred
   */

    public static <T, S> Pair<T, S> of(T firstElement, S secondElement) {
        return new Pair<T, S>(firstElement, secondElement);
    }

    public T first() {
        return first;
    }

    public S second() {
        return second;
    }

    public String toString() {
        return "(" + first + "," + second + ")";
    }

    public boolean equals(Object otherObject) {
        if (this == otherObject)
            return true;
        if (otherObject == null || !(otherObject instanceof Pair))
            return false;
        @SuppressWarnings("unchecked") Pair<T, S> other = (Pair<T, S>) otherObject;
        return Objects.equals(first, other.first) &&
                Objects.equals(second, other.second);
    }
}