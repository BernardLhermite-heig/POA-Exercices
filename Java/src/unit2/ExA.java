package unit2;

import data.Pays;

import java.util.Arrays;

public class ExA {
    public static void main(String[] args) {
        String[] words = Pays.get();

        Arrays.sort(words, (a, b) -> b.length() - a.length());

        for (int i = 0; i < 10; i++)
            System.out.println(words[i]);
    }
}
