import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class MainClass {

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        System.out.println(findMissingNumber(arr));


        MyDequeImp<Integer> dequeImp = new MyDequeImp<>();
        dequeImp.pushHead(1);
        dequeImp.pushHead(2);
        System.out.println(dequeImp.poolHead());

    }

    public static int findMissingNumber(Integer[] arr) {
        var sumFull = (arr.length + 1) * arr.length / 2 + (arr.length + 1);
        var sumFind = Arrays.stream(arr).mapToInt(Integer::intValue).sum();
        return sumFull - sumFind;
    }



}

