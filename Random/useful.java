import java.util.*;

public class useful {

    public static void main(String[] args) {

        /*
         * Java Utility Program
         * --------------------
         * This program demonstrates common Java operations:
         * 1. Check if a String is empty
         * 2. Sort a List
         * 3. Remove duplicate values
         * 4. Find the maximum number
         * 5. Convert a List into a comma-separated String
         * 6. Count occurrences of a specific value
         */

        // 1. Check if a String is empty
        String str = "Hello Java";

        boolean empty = str == null || str.isBlank();

        System.out.println("Is string empty? " + empty);


        // 2. Create a List
        List<String> list = new ArrayList<>(
                Arrays.asList("Java", "Python", "Java", "C++", "Java")
        );

        System.out.println("\nOriginal List: " + list);


        // 3. Sort a List
        list.sort(Comparator.naturalOrder());

        System.out.println("Sorted List: " + list);


        // 4. Remove duplicates
        list = list.stream()
                   .distinct()
                   .toList();

        System.out.println("Without Duplicates: " + list);


        // 5. Find maximum number
        List<Integer> numbers = Arrays.asList(10, 50, 20, 90, 30);

        int max = numbers.stream()
                         .max(Integer::compareTo)
                         .orElse(0);

        System.out.println("Maximum Number: " + max);


        // 6. Convert List<String> to comma-separated String
        String result = String.join(", ", list);

        System.out.println("Comma Separated: " + result);


        // 7. Count occurrences of "Java"
        List<String> languages = Arrays.asList(
                "Java", "Python", "Java", "C++", "Java"
        );

        long count = languages.stream()
                              .filter(x -> x.equals("Java"))
                              .count();

        System.out.println("Java Count: " + count);
    }
}