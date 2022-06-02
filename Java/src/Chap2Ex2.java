import java.util.Comparator;

public class Chap2Ex2 {
    public static <T> Comparator<T> reverse(Comparator<T> comp) {
        return (a, b) -> comp.compare(b, a);
    }
}
