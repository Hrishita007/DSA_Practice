//fruits in the baskets
import java.util.HashMap;
class leetcode904 {
    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0;
        int max = 0;

        for (int r = 0; r < fruits.length; r++) {

            // Add current fruit
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            // Shrink until only 2 fruit types remain
            while (map.size() > 2) {

                int leftFruit = fruits[l];

                map.put(leftFruit, map.get(leftFruit) - 1);

                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }

                l++;
            }

            // Update answer
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}