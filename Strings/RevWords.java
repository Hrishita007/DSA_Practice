//Reverse Words in a String
class RevWords {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);

            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
    public static void main(String[] args) {
        RevWords revWords = new RevWords();
        String input = "  hello world  ";
        String output = revWords.reverseWords(input);
        System.out.println(output); // Output: "world hello"
    }
}