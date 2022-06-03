import data.Pays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Words {
    public static int vowels(String w) {
        return w.length() - w.toLowerCase().replaceAll("[aâàäæeéêèëiîïoôœöuûùüyÿ]", "").length();
    }
}

public class Chap2Ex5 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(Pays.get());
        Collections.sort(words, Comparator.comparing(Words::vowels).thenComparing(String::compareTo));
        System.out.println(words);
    }
}
