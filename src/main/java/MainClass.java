import java.util.*;

public class MainClass {
    private static final Random random = new Random();
    private static final double[] prices = new double[]{100d, 200d, 300d, 400d, 500d, 600d, 700d};
    private static final int[] ram = new int[]{4, 8, 16, 20, 24};

    public static final int COUNT_NOTEBOOKS = 10000;

    public static void main(String[] args) {
        Notebook[] array = new Notebook[COUNT_NOTEBOOKS];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Notebook(randomPrice(), randomRam(), randomEnum(Brand.class));
        }

//        for (Notebook note : array) {
//            System.out.println(note);
//        }

//        System.out.println();
//        var array1 = new ArrayList<>(List.of(array));
//        array1.sort(new NotebookCompare());


        var start = System.currentTimeMillis();
        mySortMarge(array, new NotebookCompare());
        var end = System.currentTimeMillis();

        System.out.println("time  " + (end - start));

//        for (Notebook note : array) {
//            System.out.println(note);
//        }
    }

    public static <T> void mySortMarge(T[] array, Comparator<T> comparator) {
        @SuppressWarnings("unchecked")
        T[] tmp = (T[]) new Object[array.length];

        T[] in = array;
        T[] out = tmp;

        for (int i = 1; i < array.length; i *= 2) { // размер группы
            int p1;
            int p2;
            int j = 0;
            while (j < array.length) {  // проход по всем группам 2x

                p1 = 0;
                p2 = i;

                if ((j + 2 * i) < array.length) { // проход внутри групп 2x полным
                    for (int pos = j; pos < j + 2 * i; pos++) {
                        if (p1 < i && p2 < 2 * i) {
                            var v1 = in[j + p1];
                            var v2 = in[j + p2];
                            if (comparator.compare(v1, v2) > 0) {
                                out[pos] = v2;
                                p2++;
                            } else {
                                out[pos] = v1;
                                p1++;
                            }

                        } else if (p1 >= i) {
                            out[pos] = in[j + p2];
                            p2++;

                        } else {
                            out[pos] = in[j + p1];
                            p1++;
                        }
                    }
                } else { // проход внутри группы 2x неполной

                    int remains = array.length - j;
                    int groupA;
                    int groupB;
                    if (remains <= i) {
                        groupA = remains;
                        groupB = 0;
                    } else {
                        groupA = i;
                        groupB = remains;

                    }

                    for (int pos = j; pos < array.length; pos++) {
                        if (p1 < groupA && p2 < groupB) {
                            var v1 = in[j + p1];
                            var v2 = in[j + p2];
                            if (comparator.compare(v1, v2) > 0) {
                                out[pos] = v2;
                                p2++;
                            } else {
                                out[pos] = v1;
                                p1++;
                            }

                        } else if (p1 >= groupA) {
                            out[pos] = in[j + p2];
                            p2++;

                        } else {
                            out[pos] = in[j + p1];
                            p1++;
                        }
                    }
                }
                j += (2 * i);
            }

            tmp = in;
            in = out;
            out = tmp;
        }

        System.arraycopy(in, 0, array, 0, array.length);
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
