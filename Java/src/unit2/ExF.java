package unit2;

import data.Pays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class ExF {
    public static void main(String[] args) {
        List<String> words = Pays.getList();

        String[] wordArray = Collections2.toArray(words, String[]::new);
        Arrays.sort(wordArray);
        for (int i = 0; i < 10; i++)
            System.out.println(wordArray[i].toUpperCase());

        // Note: If wordArray was an Object[], you couldn't call
        // wordArray[i].toUpperCase().
    }
}

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