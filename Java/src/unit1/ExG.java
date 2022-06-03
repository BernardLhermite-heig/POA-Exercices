package unit1;


import java.util.*;

public class ExG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Set<Integer>> index = new TreeMap<>();
        int line = 0;
        while (in.hasNextLine()) {
            line++;
            for (String word : in.nextLine().split("[^'\\pL]+")) {
//                Set<String> lines = index.get(word);
//                if (lines == null)
//                {
//                    lines = new TreeSet<>();
//                    index.put(word, lines);
//                }
//                lines.add(line);
                index.merge(word, new TreeSet<>(), (oldValue, value) -> {
                    oldValue.addAll(value);
                    return oldValue;
                });

                Set<Integer> lines = index.get(word);
                lines.add(line);
            }
        }
        System.out.println(index);
    }
}
