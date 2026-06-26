//anagrams in a string
import java.util.*;
class leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int k=p.length();
        int n=s.length();
        if(k > n) {
            return ans;
        }
        int[] target=new int[26];
        for(char ch : p.toCharArray()) {
            target[ch-'a']++;
        }
        int[] window=new int[26];
        for(int r = 0; r < n; r++) {

            window[s.charAt(r) - 'a']++;

            if(r >= k) {

                window[s.charAt(r - k)-'a']--;
            }

            if(r >= k - 1) {

                if(Arrays.equals(target,window)) {
                    ans.add(r-k+1);
                }
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        leetcode438 solution = new leetcode438();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println(result); // Output: [0, 6]
    }
}

