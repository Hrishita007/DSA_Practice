import java.util.*;
public class strings {  
    public static void main(String[] args) {  
    //     // Create a string
    //     String str = "Hello, World!";

    //     // Print the string
    //     System.out.println("String: " + str);

    //     // Get the length of the string
    //     int length = str.length();
    //     System.out.println("Length of the string: " + length);

    //     // Convert to uppercase
    //     String upperStr = str.toUpperCase();
    //     System.out.println("Uppercase: " + upperStr);

    //     // Convert to lowercase
    //     String lowerStr = str.toLowerCase();
    //     System.out.println("Lowercase: " + lowerStr);

    //     // Extract a substring
    //     String subStr = str.substring(7, 12);
    //     System.out.println("Substring: " + subStr);

    //     // Replace characters
    //     String replacedStr = str.replace("World", "Java");
    //     System.out.println("Replaced String: " + replacedStr);

    //     // Split the string
    //     String[] parts = str.split(", ");
    //     System.out.println("Split parts:");
    //     for (String part : parts) {
    //         System.out.println(part);
    //     }

    //     // Check if the string contains a substring
    //     boolean contains = str.contains("Hello");
    //     System.out.println("Contains 'Hello': " + contains);

    //     //parse string to integer
    //     String str1 = "123";
    //    int number = Integer.parseInt(str1);
    //    System.out.println(number);

    //    //parse integer to string
    //    int number2 = 123;
    //   String str2 = Integer.toString(number2);
    //   System.out.println(str2.length());

      // Take an array of Strings input from the user & find the cumulative (combined) length of all those strings.

      Scanner sc = new Scanner(System.in);
    //   int size = sc.nextInt();
    //   String array[] = new String[size];
    //   int totLength = 0;


    //  for(int i=0; i<size; i++) {
    //    array[i] = sc.next();
    //    totLength += array[i].length();
    //  }


    //  System.out.println(totLength);


     // Replace all occurrences of 'e' with 'i'
    //  String str3String = sc.next();
    //  String result = "";


    //  for(int i=0; i<str3String.length(); i++) {
    //    if(str3String.charAt(i) == 'e') {
    //      result += 'i';
    //    } else {
    //      result += str3String.charAt(i);
    //    }
    //  }


    //  System.out.println(result);


    //string builder operations- setCharAt, insert, append,delete,reverse
    StringBuilder sb = new StringBuilder("Hello");
    sb.append(" World"); // Append
    System.out.println("After Append: " + sb.toString()); 
    sb.insert(5, ","); // Insert
    System.out.println("After Insert: " + sb.toString());       
    sb.setCharAt(0, 'h'); // Set Character at index
    System.out.println("After SetCharAt: " + sb.toString());
    sb.delete(5, 6); // Delete
    System.out.println("After Delete: " + sb.toString());
    sb.reverse(); // Reverse
    System.out.println("After Reverse: " + sb.toString());
    
    StringBuilder sb1 = new StringBuilder("HelloWorld");
     for(int i=0; i<sb1.length()/2; i++) {
       int front = i;
       int back = sb1.length() - i - 1;


       char frontChar = sb1.charAt(front);
       char backChar = sb1.charAt(back);


       sb1.setCharAt(front, backChar);
       sb1.setCharAt(back, frontChar);
     }


     System.out.println(sb1);

    }
    
}
