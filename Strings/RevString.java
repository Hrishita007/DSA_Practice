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