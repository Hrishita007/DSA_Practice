//group anagrams
//time complexity: O(n*klogk) where n is the number of strings and k is the maximum length of a string
//space complexity: O(nk) where n is the number of strings and k is the maximum length of a string
import java.util.*;
class leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();
        for (String word:strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        leetcode49 solution = new leetcode49();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = solution.groupAnagrams(strs);

        System.out.println("Grouped Anagrams: " + result);
    }
}

// //optimization
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {

//         Map<String, List<String>> map = new HashMap<>();

//         for (String word : strs) {

//             int[] freq = new int[26];

//             // Count character frequencies
//             for (char ch : word.toCharArray()) {
//                 freq[ch - 'a']++;
//             }

//             // Convert frequency array into a unique String key
//             StringBuilder sb = new StringBuilder();

//             for (int count : freq) {
//                 sb.append(count);
//                 sb.append('#');
//             }

//             String key = sb.toString();

//             if (!map.containsKey(key)) {
//                 map.put(key, new ArrayList<>());
//             }

//             map.get(key).add(word);
//         }

//         return new ArrayList<>(map.values());
//     }
// }