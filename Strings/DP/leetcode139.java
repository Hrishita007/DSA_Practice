//word break problem
//time complexity: O(n^3)
//space complexity: O(n)
import java.util.*;
class leetcode139 {

    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s, wordDict);
    }

    public boolean solve(String s, List<String> wordDict) {

        // Base case
        if (s.length() == 0) {
            return true;
        }

        // Already solved?
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        // Try every dictionary word
        for (String word : wordDict) {

            if (s.startsWith(word)) {

                String remaining = s.substring(word.length());

                if (solve(remaining, wordDict)) {

                    memo.put(s, true);

                    return true;
                }
            }
        }

        memo.put(s, false);

        return false;
    }
    public static void main(String[] args) {
        leetcode139 obj = new leetcode139();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(obj.wordBreak(s, wordDict));
    }
}