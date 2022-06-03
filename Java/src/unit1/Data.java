package unit1;

public class Data {
    public static double average(Object[] objects, Measurer meas) {
        double sum = 0;
        for (Object obj : objects) {
            sum = sum + meas.getMeasure(obj);
        }
        if (objects.length > 0) {
            return sum / objects.length;
        } else {
            return 0;
        }
    }
}