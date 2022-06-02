import java.io.IOException;
import java.util.Arrays;

public class Chap2Ex1 {
    public static void main(String[] args) throws IOException {
        var words = Pays.get();
        // Code custom ici
        Arrays.sort(words, (a, b) -> b.length() - a.length());

        for (int i = 0; i < 10; i++)
            System.out.println(words[i]);
    }


}