import java.util.HashMap;

public class leetcode567 {
    public boolean checkInclusion(String s1, String s2) {

        int k = s1.length();
        int n = s2.length();

        if(k > n) {
            return false;
        }

        HashMap<Character, Integer> target = new HashMap<>();

        for(char ch : s1.toCharArray()) {
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();

        for(int r = 0; r < n; r++) {

            char addChar = s2.charAt(r);

            window.put(
                addChar,
                window.getOrDefault(addChar, 0) + 1
            );

            if(r >= k) {

                char removeChar = s2.charAt(r - k);

                window.put(
                    removeChar,
                    window.get(removeChar) - 1
                );

                if(window.get(removeChar) == 0) {
                    window.remove(removeChar);
                }
            }

            if(r >= k - 1) {

                if(window.equals(target)) {
                    return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        leetcode567 solution = new leetcode567();
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = solution.checkInclusion(s1, s2);
        System.out.println(result); // Output: true
    }
}


//optimal for lowercase using int[26] instead of hashmap
// class Solution {
//     public boolean checkInclusion(String s1, String s2) {

//         int k = s1.length();
//         int n = s2.length();

//         if(k > n) {
//             return false;
//         }

//        int[] target=new int[26];

//         for(char ch : s1.toCharArray()) {
//             target[ch-'a']++;
//         }

//        int[] window=new int[26];
//         for(int r = 0; r < n; r++) {

//             window[s2.charAt(r) - 'a']++;

//             if(r >= k) {

//                 window[s2.charAt(r - k)-'a']--;
//             }

//             if(r >= k - 1) {

//                 if(Arrays.equals(target,window)) {
//                     return true;
//                 }
//             }
//         }

//         return false;
//     }
// }