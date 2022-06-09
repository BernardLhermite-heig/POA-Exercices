package unit3;

import java.text.Normalizer;
import java.util.stream.Stream;

public class ExC {
    public static long distinctVowels(String str) {
        return Stream.of(str.split(""))
                .map(c -> Normalizer.normalize(c, Normalizer.Form.NFD).substring(0, 1))
                .filter("aeiou"::contains)
                .distinct()
                .count();
    }
}