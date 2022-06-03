import data.Pays;

import java.util.Arrays;

public class Unit2ExA {
    public static void main(String[] args) {
        var words = Pays.get();
        // Code custom ici
        Arrays.sort(words, (a, b) -> b.length() - a.length());

        for (int i = 0; i < 10; i++)
            System.out.println(words[i]);
    }


}