//Trapping Rain Water
// Time Complexity: O(n), Space Complexity: O(1)
public class leetcode42 {
    public int trap(int[] height) {
        int l=0,r=height.length-1,res=0;
        int maxl=height[l], maxr=height[r];
        while(l<r){
            if(maxl<=maxr){
                l++;
                maxl=Math.max(maxl,height[l]);
                res+=maxl-height[l];
                }
            else{
                r--;
                maxr=Math.max(maxr,height[r]);
                res+=maxr-height[r];
            }
        }
         return res;
    }
    public static void main(String[] args) {
        leetcode42 l=new leetcode42();
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(l.trap(height));
    }  
}
