package ASSESSMENTS;

/*. Matrix — Count Divisible by K

From your description, the problem is:

Given a matrix containing land (1) and water (0) and an integer k, find the number of islands whose size/number of cells is divisible by k.

An island is a group of connected 1s, where cells are connected up, down, left, or right.

Example
1 1 0
0 1 0
1 0 1

There are 3 islands:

Island 1 → 3 cells
Island 2 → 1 cell
Island 3 → 1 cell

If:

k = 3

Only the first island has size divisible by 3.

Answer:

1 */

class Islandcount {

    public int countIslands(int[][] grid, int k) {

        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {

                    int size = dfs(grid, i, j);

                    if (size % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private int dfs(int[][] grid, int r, int c) {

        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            grid[r][c] == 0) {
            return 0;
        }

        // Mark as visited
        grid[r][c] = 0;

        int size = 1;

        size += dfs(grid, r + 1, c); // down
        size += dfs(grid, r - 1, c); // up
        size += dfs(grid, r, c + 1); // right
        size += dfs(grid, r, c - 1); // left

        return size;
    }
    public static void main(String[] args) {
        Islandcount ic = new Islandcount();
        int[][] grid = {
            {1, 1, 0},
            {0, 1, 0},
            {1, 0, 1}
        };
        int k = 3;
        int result = ic.countIslands(grid, k);
        System.out.println(result); // Output: 1
    }
}
