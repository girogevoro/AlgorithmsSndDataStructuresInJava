import java.util.*;

public class HashTableImpl<K, V> implements HashTable<K, V> {
    private final List<Item<K, V>>[] data;
    private final Item<K, V> emptyItem;
    private int size;

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("key: %s -> value: %s", key, value);
        }
    }

    public HashTableImpl(int initialCapacity) {
        this.data = new List[initialCapacity * 2];
        emptyItem = new Item<>(null, null);
    }

    public HashTableImpl() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }

        int indexFromHashFunc = hashFunc(key);
        int n = 0;

        if (data[indexFromHashFunc] != null) {
            for (Item<K, V> item : data[indexFromHashFunc]) {
                if (isKeysEquals(item, key)) {
                    item.setValue(value);
                    return true;
                }
            }
        }

        if (data[indexFromHashFunc] == null) {
            data[indexFromHashFunc] = new ArrayList<>();
        }
        data[indexFromHashFunc].add(new Item<>(key, value));
        return true;
    }

    private int getDoubleHash(K key) {
        int n = data.length / 2;
        return n - (key.hashCode() % n);
    }

    private int getStepQuadratic(int i) {
        return (int) Math.pow(i, 2);
    }

    private int getStepLinear() {
        return 1;
    }

    private boolean isKeysEquals(Item<K, V> item, K key) {
        if (item == emptyItem) {
            return false;
        }
        return (item.getKey() == null) ? (key == null) : (item.getKey().equals(key));
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);

        if (data[index] != null) {
            for (Item<K, V> item : data[index]) {
                if (isKeysEquals(item, key)) {
                    return item.value;
                }
            }
        }

        return null;
    }

//    private int indexOf(K key) {
//        int indexFromHashFunc = hashFunc(key);
//
//        int count = 0;
//        while (count++ < data.length) {
//            if (data[indexFromHashFunc] == null) {
//                break;
//            }
//            if (isKeysEquals(data[indexFromHashFunc], key)) {
//                return indexFromHashFunc;
//            }
//            indexFromHashFunc += getDoubleHash(key);
//            indexFromHashFunc %= data.length;
//        }
//
//        return -1;
//    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        if (data[index] == null) {
            return null;
        }

        for (Item<K, V> item : data[index]) {
            if (isKeysEquals(item, key)) {
                V value = item.value;
                data[index].remove(item);
                return value;
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%s = [%s]%n", i, data[i]));
        }
        return sb.toString();
    }
}
