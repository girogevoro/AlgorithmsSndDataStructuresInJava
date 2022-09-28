import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class MainClassTest {

    static DegreeCalculator calculator;

    @BeforeAll
    static void init() {
        calculator = new DegreeCalculator();
    }
    @Test
    void pow() {
        Assertions.assertEquals(calculator.degree(1, 0) , 1);
        Assertions.assertEquals(calculator.degree(8, 1) , 8);
        Assertions.assertEquals(calculator.degree(1, 2) , 1);
        Assertions.assertEquals(calculator.degree(2, 2) , 4);
        Assertions.assertEquals(calculator.degree(3, 2) , 9);
        Assertions.assertEquals(calculator.degree(7, 7) , 823543);
    }
}