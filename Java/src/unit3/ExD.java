package unit3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ExD {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String filename = in.next();
        try (Stream<String> lineStream = Files.lines(Paths.get(filename))) {
            long count = lineStream
                    .filter(w -> Words.distinctVowels(w) == 5)
                    .count();
            System.out.println(count + " words with 5 distinct vowels");
        }

        try (Stream<String> lineStream = Files.lines(Paths.get(filename))) {
            List<String> result = lineStream
                    .filter(w -> Words.distinctVowels(w) == 5)
                    .sorted((a, b) -> a.length() - b.length())
                    .sorted(Comparator.comparingInt(String::length))
                    .limit(20)
                    .collect(Collectors.toList());
            System.out.println(result);
        }
    }
}

class Words {
    public static long distinctVowels(String str) {
        return Stream.of(str.split(""))
                .map(c -> Normalizer.normalize(c, Normalizer.Form.NFD).substring(0, 1))
                .filter("aeiou"::contains)
                .distinct()
                .count();
    }
}