//number of islands
//time complexity: O(m * n) where m is the number of rows and n is the number of columns in the grid
//space complexity: O(m * n) in the worst case when the grid is filled with land
package Graphs;

public class leetcode200 {
    public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
        return 0;
    }

    int count = 0;

    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {

            if (grid[i][j] == '1') {
                dfs(grid, i, j);
                count++;
            }
        }
    }

    return count;
}

private void dfs(char[][] grid, int i, int j) {

    if (i < 0 || i >= grid.length
            || j < 0 || j >= grid[0].length
            || grid[i][j] == '0') {
        return;
    }

    grid[i][j] = '0'; // Mark the cell as visited

    // Explore all four directions
    dfs(grid, i + 1, j); // Down
    dfs(grid, i - 1, j); // Up
    dfs(grid, i, j + 1); // Right
    dfs(grid, i, j - 1); // Left
    }
    public static void main(String[] args) {
        leetcode200 solution = new leetcode200();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int numIslands = solution.numIslands(grid);
        System.out.println("Number of islands: " + numIslands); // Output: 3
    }
}  

