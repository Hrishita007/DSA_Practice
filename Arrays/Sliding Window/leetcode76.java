//minimum substring window
class leetcode76 {

    public String minWindow(String s, String t) {

        if(s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> target = new HashMap<>();

        for(char ch : t.toCharArray()) {
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();

        int l = 0;
        int matched = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for(int r = 0; r < s.length(); r++) {

            char rightChar = s.charAt(r);

            window.put(
                rightChar,
                window.getOrDefault(rightChar, 0) + 1
            );

            if(target.containsKey(rightChar) &&
               window.get(rightChar) <= target.get(rightChar)) {

                matched++;
            }

            while(matched == t.length()) {

                if(r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }

                char leftChar = s.charAt(l);

                window.put(
                    leftChar,
                    window.get(leftChar) - 1
                );

                if(target.containsKey(leftChar) &&
                   window.get(leftChar) < target.get(leftChar)) {

                    matched--;
                }

                l++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
    public static void main(String[] args) {
        leetcode76 obj = new leetcode76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(obj.minWindow(s, t));
    }
}

// class Solution {

//     public String minWindow(String s, String t) {

//         HashMap<Character, Integer> target = new HashMap<>();

//         for(char ch : t.toCharArray()) {
//             target.put(ch, target.getOrDefault(ch, 0) + 1);
//         }

//         String ans = "";
//         int minLen = Integer.MAX_VALUE;

//         for(int i = 0; i < s.length(); i++) {

//             for(int j = i + 1; j <= s.length(); j++) {

//                 String sub = s.substring(i, j);

//                 if(isValid(sub, target)) {

//                     if(sub.length() < minLen) {
//                         minLen = sub.length();
//                         ans = sub;
//                     }
//                 }
//             }
//         }

//         return ans;
//     }

//     private boolean isValid(String sub,
//                             HashMap<Character, Integer> target) {

//         HashMap<Character, Integer> freq = new HashMap<>();

//         for(char ch : sub.toCharArray()) {
//             freq.put(ch, freq.getOrDefault(ch, 0) + 1);
//         }

//         for(Character ch : target.keySet()) {

//             if(freq.getOrDefault(ch, 0) < target.get(ch)) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }
