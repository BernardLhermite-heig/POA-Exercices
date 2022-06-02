import java.util.function.Predicate;

public class Chap2Ex3 {
    public static Predicate<String> longerThan(int n) {
        return s -> s.length() > n;
    }
}
