package unit1;

import data.Pays;

import java.util.List;

public class ExD {
    public static void main(String[] args) {
        List<String> words = Pays.getList();
        words.removeIf(s -> s.length() < 20);
        System.out.println(words);
    }
}
