//Reverse a string in Java
public class RevString {
    public static void main(String[] args) {
        String s = "hello";

        String reversed = new StringBuilder(s).reverse().toString();

        System.out.println(reversed);
    }
    public static String reverseString(String s) {
        StringBuilder reversed = new StringBuilder(s);
        return reversed.reverse().toString();
    }

}

//example usage
//String s = "hello";
//String reversed = reverseString(s);
//System.out.println(reversed); // Output: "olleh"

//Reverse without using Reverse method
// public class RevString {
//     public static void main(String[] args) {
//         String s = "hello";
//         String reversed = reverseString(s);
//         System.out.println(reversed); // Output: "olleh"
//     }

//     public static String reverseString(String s) {
//         char[] charArray = s.toCharArray();
//         int left = 0;
//         int right = charArray.length - 1;

//         while (left < right) {
//             // Swap characters
//             char temp = charArray[left];
//             charArray[left] = charArray[right];
//             charArray[right] = temp;

//             left++;
//             right--;
//         }

//         return new String(charArray);
//     }
//     public static String reverseStringRecursively(String s) {
//         if (s.isEmpty()) {
//             return s;
//         }
//         return reverseStringRecursively(s.substring(1)) + s.charAt(0);
//     }
// }