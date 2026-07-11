//longest palindromic substring
// Time Complexity: O(n^2), Space Complexity: O(1)
class leetcode5 {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {

            int odd = expand(s, i, i);
            int even = expand(s, i, i + 1);
            int len=Math.max(odd,even);
            if(len>maxLength){
                maxLength=Math.max(maxLength,len);
                start=i-(len-1)/2;
            }
        }
        return s.substring(start, start + maxLength);
    }
    int expand(String s,int left, int right) {

    while (left >= 0 &&
           right < s.length() &&
           s.charAt(left) == s.charAt(right)) {

        left--;
        right++;
    }

    return right - left - 1;
    }
    public static void main(String[] args) {
        leetcode5 solution = new leetcode5();

        String s = "babad";

        String result = solution.longestPalindrome(s);

        System.out.println("Longest Palindromic Substring: " + result);
    }
}