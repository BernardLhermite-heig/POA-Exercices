import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

class Collections2 {
    public static <T> T[] toArray(Collection<T> coll,
                                  Function<Integer, T[]> constructor) {
        T[] result = constructor.apply(coll.size());
        Iterator<T> iter = coll.iterator();
        for (int i = 0; i < result.length; i++)
            result[i] = iter.next();
        return result;
    }
}

public class Unit2ExF {
    public static void main(String[] args) throws IOException {
        List<String> words = Files.readAllLines(Paths.get("pays.txt"));

        String[] wordArray = Collections2.toArray(words, String[]::new);
        Arrays.sort(wordArray);
        for (int i = 0; i < 10; i++)
            System.out.println(wordArray[i].toUpperCase());

        // Note: If wordArray was an Object[], you couldn't call
        // wordArray[i].toUpperCase().
    }
}