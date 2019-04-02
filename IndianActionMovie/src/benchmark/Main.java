//Засечь и сравнить время добавления и удаления у разных коллекций

package benchmark;

import java.util.*;

public class Main {

    private static ArrayList<Integer> arrayList = new ArrayList<>();
    private static LinkedList<Integer> linkedList = new LinkedList<>();

    private static HashSet<Integer> hashSet = new HashSet<>();
    private static TreeSet<Integer> treeSet = new TreeSet<>();

    private static HashMap<Integer, Integer> hashMap = new HashMap<>();
    private static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    private static long first, last;

    private static void collectionTest(Collection<Integer> collection) {
        first = System.currentTimeMillis();
        for (int i = 0; i < 1000000; ++i) {
            collection.add(i);
        }
        last = System.currentTimeMillis();
        System.out.println("Время добавления = " + (last - first));
        first = System.currentTimeMillis();
        for (int i = 0; i < 1000000; ++i) {
            collection.remove(i);
        }
        last = System.currentTimeMillis();
        System.out.println("Время удаления = " + (last - first));
    }

    private static void mapTest(Map<Integer, Integer> map) {
        first = System.currentTimeMillis();
        for (int i = 0; i < 1000000; ++i) {
            map.put(i, 2*i);
        }
        last = System.currentTimeMillis();
        System.out.println("Время добавления = " + (last - first));

        first = System.currentTimeMillis();
        for (int i = 0; i < 1000000; ++i) {
            map.remove(i);
        }
        last = System.currentTimeMillis();
        System.out.println("Время удаления = " + (last - first));
    }

    public static void main(String[] args) {

        System.out.println("        Сравнение ArrayList и LinkedList");
        System.out.println("ArrayList:");
        collectionTest(arrayList);
        System.out.println("LinkedList:");
        collectionTest(linkedList);

        System.out.println("        Сравнение HashSet и TreeSet");
        System.out.println("HashSet:");
        collectionTest(hashSet);
        System.out.println("TreeSet:");
        collectionTest(treeSet);

        System.out.println("        Сравнение HashMap и TreeMap");
        System.out.println("HashMap:");
        mapTest(hashMap);
        System.out.println("TreeMap:");
        mapTest(treeMap);
    }
}
