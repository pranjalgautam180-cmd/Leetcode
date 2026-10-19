class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int r = 0, c = 0;
        visited[0][0] = true;

        while (true) {
            int nr = r;
            int nc = c;

            // Find the next cell
            if (grid[r][c] == 'L') {
                nc--;
            } else if (grid[r][c] == 'R') {
                nc++;
            } else if (grid[r][c] == 'U') {
                nr--;
            } else if (grid[r][c] == 'D') {
                nr++;
            }

            // Stop if outside the grid
            if (nr < 0 || nr >= m ||
                nc < 0 || nc >= n) {
                break;
            }

            // Stop if the cell is already visited
            if (visited[nr][nc]) {
                break;
            }

            // Move to the next cell
            r = nr;
            c = nc;
            visited[r][c] = true;
        }

        return new int[]{r, c};
    }
}