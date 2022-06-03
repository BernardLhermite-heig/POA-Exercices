package unit2;

import java.util.function.Predicate;

/**
 * Description.
 *
 * @author Marengo Stéphane
 * @author Silvestri Géraud
 */
public class Words {
    public static Predicate<String> longerThan(int n) {
        return s -> s.length() > n;
    }

    public static int vowels(String w) {
        return w.length() - w.toLowerCase().replaceAll("[aâàäæeéêèëiîïoôœöuûùüyÿ]", "").length();
    }
}
