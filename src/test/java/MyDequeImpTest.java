import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

class MyDequeImpTest {
@Test
    void test() {
    MyDeque<Integer> deque = new MyDequeImp<>();

    deque.pushHead(1);
    deque.pushHead(2);
    assertEquals(deque.peakHead(),2);
    assertEquals(deque.peakTail(),1);
    deque.pushTail(8);
    assertEquals(deque.poolTail(),8);
    assertEquals(deque.poolTail(),1);
    assertEquals(deque.poolHead(),2);

    assertNull(deque.peakTail());


    }
}