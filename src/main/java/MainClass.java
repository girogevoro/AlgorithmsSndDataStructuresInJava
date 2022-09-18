import java.lang.reflect.Array;
import java.util.*;

public class MainClass {
    private static final Random random = new Random();
    private static final double[] prices = new double[]{100d, 200d, 300d, 400d, 500d, 600d, 700d};
    private static final int[] ram = new int[]{4, 8, 16, 20, 24};

    public static void main(String[] args) {
        Notebook[] array = new Notebook[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Notebook(randomPrice(), randomRam(), randomEnum(Brand.class));
        }


        var array1 = new ArrayList<>(List.of(array));
        array1.sort(new NotebookCompare());

        for (Notebook note : array1) {
            System.out.println(note);
        }

    }




    public static double randomPrice() {
        return prices[random.nextInt(prices.length)];
    }

    public static int randomRam() {
        return ram[random.nextInt(ram.length)];
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
