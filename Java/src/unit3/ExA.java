package unit3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Streams {
    public static Stream<String> letters(String word) {
        return Stream.of(word.split(""));
        // made in géro
        // return word.codePoints().mapToObj(c -> String.valueOf((char) c));
    }

    public static Stream<String> stars() {
        return Stream.iterate("*", n -> n + "*");
    }
}

public class ExA {
    public static void main(String[] args) {
        show(Streams.letters("Hello"));
        System.out.println("Expected: H, e, l, l, o");
        show(Streams.letters("anticonstitutionnellement"));
        System.out.println("Expected: a, n, t, i, c, o, n, s, t, i, ...");
        show(Streams.stars());
        System.out.println("Expected: *, **, ***, ****, *****, ******, *******, ********, *********, **********, ...");
    }

    /**
     * Displays the first ten values in a stream, followed by ...
     * if there are additional values.
     *
     * @param stream the stream to be displayed (which is consumed
     *               in the process)
     */
    public static <T> void show(Stream<T> stream) {
        final int SHOW_LIMIT = 10;
        List<T> values = stream.limit(SHOW_LIMIT + 1).collect(
                Collectors.toList());
        for (int i = 0; i < Math.min(SHOW_LIMIT, values.size()); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(values.get(i));
        }
        if (values.size() > SHOW_LIMIT) {
            System.out.print(", ...");
        }
        System.out.println();
    }
}
