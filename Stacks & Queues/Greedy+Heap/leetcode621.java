import java.util.*;

class leetcode621 {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0) {
                pq.add(f);
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i <= n; i++) {

                if (!pq.isEmpty()) {
                    int count = pq.poll();

                    if (count - 1 > 0) {
                        temp.add(count - 1);
                    }
                }

                time++;

                if (pq.isEmpty() && temp.isEmpty()) {
                    break;
                }
            }

            for (int count : temp) {
                pq.add(count);
            }
        }

        return time;
    }
}