//Rotting Oranges
//time complexity: O(n*m) where n is the number of rows and m is the number of columns in the grid
//space complexity: O(n*m) for the queue and the grid
import java.util.*;

class leetcode994 {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        // Put all rotten oranges into the queue
        // and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // BFS
        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] current = q.remove();

                for (int[] dir : directions) {

                    int nr = current[0] + dir[0];
                    int nc = current[1] + dir[1];

                    if (nr >= 0 && nr < rows &&
                        nc >= 0 && nc < cols &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;

                        q.add(new int[]{nr, nc});
                    }
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}