import java.util.*;
import java.util.stream.*;

public class StreamExamples {
    public static void main(String[] args) {
        // Create a Dummy List, Map, and Set for Stream
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        Set<String> set = new HashSet<>(Arrays.asList("Yash", "Vinit", "Dwij"));

        // Given a String, find the first non-repeated character in it using Stream functions
        String input = "aabbcde";
        char firstNonRepeated = input.chars()
                                    .mapToObj(c -> (char) c)
                                    .filter(c -> input.indexOf(c) == input.lastIndexOf(c))
                                    .findFirst()
                                    .orElse('\0');
        System.out.println(firstNonRepeated);

        // Given a String, find the first repeated character in it using Stream functions
        Optional<Character> firstRepeated = input.chars()
                                                .mapToObj(c -> (char) c)
                                                .filter(c -> input.indexOf(c) != input.lastIndexOf(c))
                                                .findFirst();
        System.out.println(firstRepeated.orElse('\0'));

        // Given a list of integers, sort all the values present in it using Stream functions
        List<Integer> sortedList = list.stream()
                                      .sorted()
                                      .collect(Collectors.toList());
        System.out.println(sortedList);

        // Concatenate two Streams
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);
        Stream<Integer> concatenatedStream = Stream.concat(stream1, stream2);
        System.out.println(concatenatedStream.collect(Collectors.toList()));

        // Convert a List of objects into a Map by considering duplicated keys and store them in sorted order
        List<String> duplicatesList = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        Map<String, Long> wordCountMap = duplicatesList.stream()
                                                       .collect(Collectors.groupingBy(
                                                               String::toLowerCase,
                                                               TreeMap::new,
                                                               Collectors.counting()));
        System.out.println(wordCountMap);

        // Count each element/word from the String ArrayList in Java 8
        List<String> wordList = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        Map<String, Long> wordCount = wordList.stream()
                                              .collect(Collectors.groupingBy(
                                                      String::toLowerCase,
                                                      Collectors.counting()));
        System.out.println(wordCount);

        // Find only duplicate elements with their count from the String ArrayList in Java 8
        Map<String, Long> duplicateWords = wordCount.entrySet()
                                                    .stream()
                                                    .filter(entry -> entry.getValue() > 1)
                                                    .collect(Collectors.toMap(
                                                            Map.Entry::getKey,
                                                            Map.Entry::getValue));
        System.out.println(duplicateWords);

        // Find the Maximum element in an array
        int[] array = {1, 2, 5, 3, 4};
        int maxElement = Arrays.stream(array).max().orElse(Integer.MIN_VALUE);
        System.out.println(maxElement);

        // Print the count of each character in a String
        String str = "hello world";
        Map<Character, Long> charCount = str.chars()
                                            .mapToObj(c -> (char) c)
                                            .collect(Collectors.groupingBy(
                                                    c -> c,
                                                    Collectors.counting()));
        System.out.println(charCount);
    }
}
