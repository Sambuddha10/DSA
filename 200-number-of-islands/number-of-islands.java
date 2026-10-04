class Solution {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // Found a new unvisited island
                if (grid[row][col] == '1') {
                    islands++;

                    // Mark this entire island as visited
                    dfs(grid, row, col);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {
        // Stop if outside the grid or at water/already visited land
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == '0') {
            return;
        }

        // Mark current land cell as visited
        grid[row][col] = '0';

        // Explore only horizontal and vertical neighbors
        dfs(grid, row + 1, col); // Down
        dfs(grid, row - 1, col); // Up
        dfs(grid, row, col + 1); // Right
        dfs(grid, row, col - 1); // Left
    }
}