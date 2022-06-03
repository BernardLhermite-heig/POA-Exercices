package unit1;

import java.util.Scanner;

public class ExA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] words = in.nextLine().split(" ");

        Measurer m = new StringMeasurer();
        double result = Data.average(words, m);
        System.out.println("Average word length: " + result);
    }
}

class StringMeasurer implements Measurer {
    public double getMeasure(Object obj) {
        return ((String) obj).length();
    }
}