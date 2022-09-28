import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ProblemTest {
    @Test
    void testFindBest(){
        List<Problem.Thing> list = new ArrayList<>();

        list.add( new Problem.Thing(10,1));
        list.add( new Problem.Thing(15,3));
        list.add( new Problem.Thing(20,5));
        list.add( new Problem.Thing(25,7));

        var bag = new Problem.Bag(15);
        var mustBest = Problem.findMustBest(list, bag);
        Assertions.assertArrayEquals(mustBest.toArray(), List.of(new Problem.Thing(15,3)).toArray());

        bag = new Problem.Bag(45);
        mustBest = Problem.findMustBest(list, bag);
        Assertions.assertArrayEquals(mustBest.toArray(), List.of(
                new Problem.Thing(20,5),
                new Problem.Thing(25,7)).toArray());

        bag = new Problem.Bag(70);
        mustBest = Problem.findMustBest(list, bag);
        Assertions.assertArrayEquals(mustBest.toArray(), List.of(
                new Problem.Thing(10,1),
                new Problem.Thing(15,3),
                new Problem.Thing(20,5),
                new Problem.Thing(25,7)).toArray());

    }

}