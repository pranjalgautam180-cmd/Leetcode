class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int startingRow = 0;
        int endingRow = n - 1;
        int startingCols = 0;
        int endingCols = m - 1;

        while (startingRow <= endingRow && startingCols <= endingCols) {

            // Top Row
            for (int col = startingCols; col <= endingCols; col++) {
                result.add(matrix[startingRow][col]);
            }
            startingRow++;

            // Right Column
            for (int row = startingRow; row <= endingRow; row++) {
                result.add(matrix[row][endingCols]);
            }
            endingCols--;

            // Bottom Row
            if (startingRow <= endingRow) {
                for (int col = endingCols; col >= startingCols; col--) {
                    result.add(matrix[endingRow][col]);
                }
                endingRow--;
            }

            // Left Column
            if (startingCols <= endingCols) {
                for (int row = endingRow; row >= startingRow; row--) {
                    result.add(matrix[row][startingCols]);
                }
                startingCols++;
            }
        }
        return result;
    }
}