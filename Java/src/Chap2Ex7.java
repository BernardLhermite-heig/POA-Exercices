import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Chap2Ex7 {
    public static <T> T[] filter(T[] values, Predicate<T> p, Function<Integer, T[]> ctor) {
        List<T> result = new ArrayList<>();
        for (T value : values) {
            if (p.test(value)) {
                result.add(value);
            }
        }

        T[] result2 = ctor.apply(result.size());
        for (int i = 0; i < result.size(); ++i) {
            result2[i] = result.get(i);
        }
        return result2;
    }
}