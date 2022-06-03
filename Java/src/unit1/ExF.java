package unit1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ExF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, String> index = new TreeMap<>();
        int line = 0;
        while (in.hasNextLine()) {
            line++;
            for (String word : in.nextLine().split("[^'\\pL]+")) {
//                String lines = index.get(word);
//                if (lines == null) index.put(word, "" + line);
//                else index.put(word, lines + ", " + line);
                index.merge(word, "" + line, (a, b) -> a + ", " + b);
            }
        }
        System.out.println(index);
    }
}
