import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class Main {
    
    static class TreeMultiSet<T> implements Iterable<T> {
        private final TreeMap<T, Integer> map;
        private int size;

        public TreeMultiSet() {
            map = new TreeMap<>();
            size = 0;
        }

        public TreeMultiSet(boolean reverse) {
            if (reverse) {
                map = new TreeMap<>(Collections.reverseOrder());
            } else {
                map = new TreeMap<>();
            }
            size = 0;
        }

        public void clear() {
            map.clear();
            size = 0;
        }

        public int size() {
            return size;
        }

        public int setSize() {
            return map.size();
        }

        public boolean contains(T a) {
            return map.containsKey(a);
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public Integer get(T a) {
            return map.getOrDefault(a, 0);
        }

        public void add(T a, int count) {
            int cur = get(a);
            map.put(a, cur + count);
            size += count;
            if (cur + count == 0) {
                map.remove(a);
            }
        }

        public void addOne(T a) {
            add(a, 1);
        }

        public void remove(T a, int count) {
            add(a, Math.max(-get(a), -count));
        }

        public void removeOne(T a) {
            remove(a, 1);
        }

        public void removeAll(T a) {
            remove(a, Integer.MAX_VALUE - 10);
        }

        public T ceiling(T a) {
            return map.ceilingKey(a);
        }

        public T floor(T a) {
            return map.floorKey(a);
        }

        public T first() {
            return map.firstKey();
        }

        public T last() {
            return map.lastKey();
        }

        public T higher(T a) {
            return map.higherKey(a);
        }

        public T lower(T a) {
            return map.lowerKey(a);
        }

        public T pollFirst() {
            T a = first();
            removeOne(a);
            return a;
        }

        public T pollLast() {
            T a = last();
            removeOne(a);
            return a;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<>() {
                private final Iterator<T> iter = map.keySet().iterator();
                private int count = 0;
                private T curElement;

                public boolean hasNext() {
                    return iter.hasNext() || count > 0;
                }

                public T next() {
                    if (count == 0) {
                        curElement = iter.next();
                        count = get(curElement);
                    }
                    count--;
                    return curElement;
                }
            };
        }
    }

    public static void main(String[] args) {
        // Create and initialize a TreeMultiSet
        TreeMultiSet<Integer> multiset = new TreeMultiSet<>();
        TreeMultiSet<Integer> multiset1 = new TreeMultiSet<>();

        // Adding elements
        multiset.addOne(5);
        multiset.addOne(2);
        multiset.addOne(1);
        multiset.addOne(5);
        multiset.addOne(3);
        multiset.addOne(2);
        multiset.addOne(1);

        // Insert elements
        multiset.addOne(4);
        multiset.addOne(2);

        // Iterating over elements
        System.out.println("Multiset elements:");
        for (Integer element : multiset) {
            System.out.print(element + " ");
        }
        System.out.println();

        // Count of a specific element
        System.out.println("Count of 2: " + multiset.get(2));

        // Find an element
        if (multiset.contains(3)) {
            System.out.println("Found: 3");
        } else {
            System.out.println("Element not found");
        }

        // Erase elements
        multiset.removeAll(1);  // Erases all occurrences of 1
        multiset.removeOne(5);  // Erases one occurrence of 5

        // Display elements after erasure
        System.out.println("Multiset after erasures:");
        for (Integer element : multiset) {
            System.out.print(element + " ");
        }
        System.out.println();

        // Elements equal to 2
        System.out.println("Elements equal to 2:");
        for (int i = 0; i < multiset.get(2); i++) {
            System.out.print(2 + " ");
        }
        System.out.println();

        // Using higher() method
        Integer higherThan2 = multiset.higher(2);
        System.out.println("Element higher than 2: " + (higherThan2 != null ? higherThan2 : "None"));

        // Using lower() method
        Integer lowerThan3 = multiset.lower(3);
        System.out.println("Element lower than 3: " + (lowerThan3 != null ? lowerThan3 : "None"));
    }
}
