//longest common prefix
//time complexity: O(n*m) where n is the number of strings and m is the length of the shortest string
//space complexity: O(1)
class leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++){
            for (int j = 1; j < strs.length; j++){
                if(i==strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i))
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
    public static void main(String[] args) {
        leetcode14 solution = new leetcode14();

        String[] strs = {"flower", "flow", "flight"};

        String result = solution.longestCommonPrefix(strs);

        System.out.println("Longest Common Prefix: " + result);
    }
}