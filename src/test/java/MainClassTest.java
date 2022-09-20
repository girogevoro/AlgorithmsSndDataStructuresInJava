import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainClassTest {

    @Test
    void testFind() {

//         [1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        assertEquals(MainClass.findMissingNumber(arr), 11);

//        2. [1, 2, 4, 5, 6] => 3
        arr = new Integer[]{1, 2, 4, 5, 6};
        assertEquals(MainClass.findMissingNumber(arr), 3);

        //        3. [2, 3, 4, 5, 6, 7, 8] => 1
        arr = new Integer[]{2, 3, 4, 5, 6, 7, 8};
        assertEquals(MainClass.findMissingNumber(arr), 1);

        //        4. [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14] => 15
        arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        assertEquals(MainClass.findMissingNumber(arr), 15);

        //        5. [] => 1
        arr = new Integer[]{};
        assertEquals(MainClass.findMissingNumber(arr), 1);
    }

}