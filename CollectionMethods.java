import java.util.*;


import java.util.concurrent.ConcurrentHashMap;

public class CollectionMethods {
    public static void main(String[] args) {
        // List
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Yash");
        arrayList.add("Vinit");
        System.out.println(arrayList);
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.contains("Yash"));
        System.out.println(arrayList.get(0));
        arrayList.remove("Yash");
        System.out.println(arrayList);

        List<String> linkedList = new LinkedList<>();
        linkedList.add("Yash");
        linkedList.add("Vinit");
        System.out.println(linkedList);
        // Other methods similar to ArrayList

        // Map
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        System.out.println(hashMap);
        System.out.println(hashMap.size());
        System.out.println(hashMap.isEmpty());
        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.containsValue("Two"));
        hashMap.remove(2);
        System.out.println(hashMap);

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3, "Three");
        linkedHashMap.put(4, "Four");
        System.out.println(linkedHashMap);
        // Other methods similar to HashMap

        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(5, "Five");
        treeMap.put(6, "Six");
        System.out.println(treeMap);
        // Other methods similar to HashMap

        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(7, "Seven");
        concurrentHashMap.put(8, "Eight");
        System.out.println(concurrentHashMap);
        // Other methods similar to HashMap

        Map<Integer, String> hashTable = new Hashtable<>();
        hashTable.put(9, "Nine");
        hashTable.put(10, "Ten");
        System.out.println(hashTable);
        // Other methods similar to HashMap

        // Set
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Yash");
        hashSet.add("Vinit");
        System.out.println(hashSet);
        System.out.println(hashSet.size());
        System.out.println(hashSet.isEmpty());
        System.out.println(hashSet.contains("Yash"));
        hashSet.remove("Yash");
        System.out.println(hashSet);

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Yash");
        treeSet.add("Vinit");
        System.out.println(treeSet);
        // Other methods similar to HashSet

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Yash");
        linkedHashSet.add("Vinit");
        System.out.println(linkedHashSet);
        // Other methods similar to HashSet

        // Queue
        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("Yash");
        priorityQueue.add("Vinit");
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.size());
        System.out.println(priorityQueue.isEmpty());
        System.out.println(priorityQueue.peek());
        priorityQueue.poll();
        System.out.println(priorityQueue);
        //Stack
        Stack<String> stack = new Stack<>();
        stack.push("Yash");
        stack.push("Vinit");
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack);
    }
}
