package unit1;

import java.util.Scanner;

public class ExB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] words = in.nextLine().split(" ");

        double result = Data.average(words, obj -> ((String) obj).length());
        System.out.println("Average word length: " + result);
    }
}