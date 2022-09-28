import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class Problem {

    public static final int MAX_Q = 15;
    public static final int MAX_P = 10;
    public static final int COUNT_THING = 50;


    public static void main(String[] args) {
        List<Thing> thingList = new ArrayList<>();

        for (int i = 0; i < COUNT_THING; i++) {
            thingList.add(Thing.instance());
        }

        var bag = new Bag(15);
        System.out.println(findMustBest(thingList, bag));

    }

    /**
     * Есть рюкзак, который вмещает x кг чего-то.
     * Есть n вещей. У каждой вещи есть ее вес p и стоимость q. p, q > 0.
     * <p>
     * Требуется максимизировать сумарную стоимость с учетом не превышения сумарного веса.
     * <p>
     * Найти самый дорогой вмещаемый набор.
     */

    static class Bag {
        private final int x;

        public int getX() {
            return x;
        }

        public Bag(int x) {
            this.x = x;
        }
    }

    public static class Thing {
        public Thing(int p, int q) {
            this.p = p;
            this.q = q;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }

        private final int p;
        private final int q;

        @Override
        public String toString() {
            return "Thing{" +
                    "p=" + p +
                    ", q=" + q +
                    '}';
        }

        public static Thing instance() {
            var random = ThreadLocalRandom.current();
            return new Thing(random.nextInt(1, MAX_Q), random.nextInt(1, MAX_P));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Thing thing = (Thing) o;
            return p == thing.p && q == thing.q;
        }

        @Override
        public int hashCode() {
            return Objects.hash(p, q);
        }
    }


    public static List<Thing> findMustBest(List<Thing> things, Bag bag) {
        List<Thing> best = new ArrayList<>();
        find(bag, things, new ArrayList<>(), new Consumer<>() {
            int maxP = 0;
            @Override
            public void accept(List<Thing> things) {
                var p = sumBugQ(things);
                if (p > maxP) {
                    maxP = p;
                    best.clear();
                    best.addAll(things);
                    System.out.println(p);
                }
            }
        });

        return best;
    }

    private static void find(Bag bag, List<Thing> things, List<Thing> find, Consumer<List<Thing>> consumer) {
        if (things.size() == 0) {
            return;
        }

        for (int i = 0; i < things.size(); i++) {
            var remains = new ArrayList<Thing>();
            var one = new ArrayList<Thing>();
            getOneAndRemains(things, i, one, remains);
            List<Thing> answer = new ArrayList<>(find);
            answer.add(one.get(0));
            if (isFull(bag, answer)) {
                return;
            }
            consumer.accept(answer);
            find(bag, remains, answer, consumer);
        }
    }

    private static void getOneAndRemains(List<Thing> in, int index, List<Thing> one, List<Thing> remains) {
        one.add(in.get(index));
        remains.addAll(in);
        remains.remove(index);
    }

    private static boolean isFull(Bag bag, List<Thing> things) {
        int p = 0;
        for (Thing thing : things) {
            p += thing.getP();
        }
        return p > bag.getX();
    }

    private static int sumBugQ(List<Thing> things) {
        int sum = 0;
        for (Thing thing : things) {
            sum += thing.getQ();
        }
        return sum;
    }

    // x = 10
    // [p, q]: [3, 6], [3, 4], [10, 9]


}
