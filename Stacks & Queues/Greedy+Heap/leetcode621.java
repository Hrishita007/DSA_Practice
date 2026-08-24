//Task Scheduler
//time complexity: O(nlogn)
//space complexity: O(n)
import java.util.*;
class leetcode621 {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq=
        new PriorityQueue<>(Collections.reverseOrder());
        int[] arr=new int[26];
        for(char t:tasks){
            arr[t-'A']++;
        }
        for(int a:arr){
            if(a>0){
                pq.add(a);
            }
        }
        int time=0;
        while(!pq.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<n+1;i++){
               if(!pq.isEmpty()){
                int cnt=pq.poll();
                cnt--;
                if(cnt>0){
                    temp.add(cnt);
                }
               }
               time++; 
               if(temp.isEmpty() && pq.isEmpty()){
                break;
                }
            }
            for (int c : temp) {
                pq.add(c);
            }
            
        }
        return time;
    }
}