//reverse queue using stack
import java.util.*;
import java.io.*;

class Queuestack {

    public static List<Integer> reverseQueue(List<Integer> queue) {
        Stack<Integer> st=new Stack<>();
        while(!queue.isEmpty()){
          st.push(queue.remove(0));
        }
        while(!st.isEmpty()){
          queue.add(st.pop());
        }
        return queue;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        List<Integer> reversed = reverseQueue(queue);
        for (int i = 0; i < reversed.size(); i++) {
            System.out.print(reversed.get(i) + (i < reversed.size()-1 ? " " : ""));
        }
        System.out.println();
        sc.close();
    }
}
