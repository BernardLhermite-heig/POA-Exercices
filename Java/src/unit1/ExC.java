package unit1;


import java.util.Scanner;

public class ExC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] words = in.nextLine().split(" ");

        double result = Data2.average(words, obj -> obj.length());
        System.out.println("Average word length: " + result);
    }
}
