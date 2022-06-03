package unit1;

public class Data2 {
    public static <T> double average(T[] objects, Measurer2<T> meas) {
        double sum = 0;
        for (T obj : objects) {
            sum = sum + meas.getMeasure(obj);
        }
        if (objects.length > 0) {
            return sum / objects.length;
        } else {
            return 0;
        }
    }
}