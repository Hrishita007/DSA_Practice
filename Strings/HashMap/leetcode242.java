//valid anagram
//time complexity: O(n)
//space complexity: O(1)
import java.util.Arrays;
class leetcode242 {
    public boolean isAnagram(String s, String t) {
        int[] smap= new int[26];
        if(s.length()!=t.length()){
            return false;
        }
        int count=0;
        for(char ch:s.toCharArray()){
            smap[ch-'a']++;
        }
        int[] tmap=new int[26];
        for(char ch:t.toCharArray()){
            tmap[ch-'a']++;
        }
        if(Arrays.equals(smap,tmap)){
            return true;
        }
        return false;

    }
    public static void main(String[] args) {
        leetcode242 solution = new leetcode242();

        String s = "anagram";
        String t = "nagaram";

        boolean result = solution.isAnagram(s, t);

        System.out.println("Are \"" + s + "\" and \"" + t + "\" anagrams? " + result);
    }
}



// // another optimization methid by counting the characters in one array and decrementing in another array
// class Solution {
//     public boolean isAnagram(String s, String t) {

//         if (s.length() != t.length()) {
//             return false;
//         }

//         int[] freq = new int[26];

//         // Increase frequency for s
//         for (char ch : s.toCharArray()) {
//             freq[ch - 'a']++;
//         }

//         // Decrease frequency for t
//         for (char ch : t.toCharArray()) {
//             freq[ch - 'a']--;
//         }

//         // Check if all counts are zero
//         for (int count : freq) {
//             if (count != 0) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }