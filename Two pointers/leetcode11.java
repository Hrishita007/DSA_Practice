class leetcode11 {
    public int maxArea(int[] height) {
        int h=height.length,l=0,r=h-1;
        int maximum=0;
        while(l<r){
            int width=r-l;
            int limiting_height=Math.min(height[l],height[r]);
            int area=width*limiting_height;
            maximum=Math.max(area,maximum);
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return maximum;
        
    }
    public static void main(String[] args) {
        leetcode11 obj=new leetcode11();
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(obj.maxArea(height));
    }
}