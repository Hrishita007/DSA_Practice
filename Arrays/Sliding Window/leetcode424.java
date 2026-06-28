//longest substring with same letters after replacement
class leetcode424 {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int l = 0;
        int max = 0;
        int maxFreq = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch=s.charAt(r);
            freq[ch-'A']++;

            maxFreq=Math.max(maxFreq,freq[ch-'A']);

            while(((r-l+1)-maxFreq)>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            max=Math.max(max,r-l+1);

        }
        return max;
        
    }
    public static void main(String[] args) {
        leetcode424 obj = new leetcode424();
        String s = "AABABBA";
        int k = 1;
        System.out.println(obj.characterReplacement(s, k)); // Output: 4
    }
}