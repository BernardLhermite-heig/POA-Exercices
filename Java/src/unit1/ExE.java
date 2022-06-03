package unit1;

import data.Pays;

import java.util.List;

public class ExE {
    public static void main(String[] args) {
        List<String> words = Pays.getList();
        words.removeIf(w ->
        {
            String first = w.substring(0, 1);
            String last = w.substring(w.length() - 1);
            return !first.equalsIgnoreCase(last);
        });
        System.out.println(words);
    }
}
