package unit2;

import data.Pays;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExE {
    public static void main(String[] args) {
        List<String> words = Pays.getList();
        Collections.sort(words, Comparator.comparing(Words::vowels).thenComparing(String::compareTo));
        System.out.println(words);
    }
}