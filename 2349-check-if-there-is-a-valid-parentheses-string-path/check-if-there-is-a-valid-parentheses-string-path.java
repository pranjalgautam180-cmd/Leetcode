class Solution {

    int m, n;
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {

        m = grid.length;
        n = grid[0].length;

        // Total number of cells must be even
        if ((m + n - 1) % 2 != 0)
            return false;

        dp = new Boolean[m][n][m + n];

        return solve(grid, 0, 0, 0);
    }

    private boolean solve(char[][] grid, int i, int j, int balance) {

        // Add current bracket to balance
        if (grid[i][j] == '(')
            balance++;
        else
            balance--;

        // Balance can never become negative
        if (balance < 0)
            return false;

        // Destination reached
        if (i == m - 1 && j == n - 1)
            return balance == 0;

        // Already calculated
        if (dp[i][j][balance] != null)
            return dp[i][j][balance];

        boolean ans = false;

        // Move Down
        if (i + 1 < m)
            ans = solve(grid, i + 1, j, balance);

        // Move Right
        if (!ans && j + 1 < n)
            ans = solve(grid, i, j + 1, balance);

        dp[i][j][balance] = ans;

        return ans;
    }
}