//random pick index with weight
class leetcode528 {
    int[] prefix;
    int totalsum;

    public leetcode528(int[] w) {
        int sum=0;
        prefix = new int[w.length];
        for(int i=0;i<w.length;i++){
            sum+=w[i];
            prefix[i]=sum;
        }
        totalsum=sum;
    }
    
    public int pickIndex() {
        int random = (int)(Math.random() * totalsum) + 1;
        int low=0,high=prefix.length-1;
        int answer=-1;
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(prefix[mid]>=random){
                answer=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] w = {1, 3, 2};
        leetcode528 obj = new leetcode528(w);
        
        // Simulate multiple calls to pickIndex to observe the distribution
        int[] count = new int[w.length];
        int trials = 100000;
        for (int i = 0; i < trials; i++) {
            int index = obj.pickIndex();
            count[index]++;
        }
        
        System.out.println("Distribution of picked indices:");
        for (int i = 0; i < count.length; i++) {
            System.out.printf("Index %d: %.2f%%\n", i, (count[i] * 100.0 / trials));
        }
    }
}

/**
 * Your leetcode528 object will be instantiated and called as such:
 * leetcode528 obj = new leetcode528(w);
 * int param_1 = obj.pickIndex();
 */