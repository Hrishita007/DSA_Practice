//longest substring without repeating characters
import java.util.*;
class leetcode3 {
    public int lengthOfLongestSubstring(String s) {
       HashSet<Character> set = new HashSet<>();
       int l=0;
       int maxlen=0;
       for(int r=0;r<s.length();r++){
        while(set.contains(s.charAt(r))){
            set.remove(s.charAt(l));
            l++;
        }
        set.add(s.charAt(r));
        maxlen=Math.max(maxlen,r-l+1);
       }
        return maxlen;
        
    }
    public static void main(String[] args) {
        leetcode3 obj = new leetcode3();
        String s = "pwwkew";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }
}


//print substring
// HashSet<Character> set = new HashSet<>();

// int l = 0;
// int maxlen = 0;
// int start = 0;

// for(int r = 0; r < s.length(); r++) {

//     while(set.contains(s.charAt(r))) {
//         set.remove(s.charAt(l));
//         l++;
//     }

//     set.add(s.charAt(r));

//     if(r - l + 1 > maxlen) {
//         maxlen = r - l + 1;
//         start = l;
//     }
// }

// return s.substring(start, start + maxlen);