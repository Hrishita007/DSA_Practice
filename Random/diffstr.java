//difference between strings, string builder and string buffer
public class diffstr {
    public static void main(String[] args) {
        // String
        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println("String comparison using '==': " + (str1 == str2)); // true, same reference
        System.out.println("String comparison using 'equals()': " + str1.equals(str2)); // true, same content

        // StringBuilder
        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("Hello");
        System.out.println("StringBuilder comparison using '==': " + (sb1 == sb2)); // false, different references
        System.out.println("StringBuilder comparison using 'equals()': " + sb1.equals(sb2)); // false, different references

        // StringBuffer
        StringBuffer sbuf1 = new StringBuffer("Hello");
        StringBuffer sbuf2 = new StringBuffer("Hello");
        System.out.println("StringBuffer comparison using '==': " + (sbuf1 == sbuf2)); // false, different references
        System.out.println("StringBuffer comparison using 'equals()': " + sbuf1.equals(sbuf2)); // false, different references
    }
    
}
