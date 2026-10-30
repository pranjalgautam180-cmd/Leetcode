import java.util.*;

class Solution {

    public int maximalRectangle(char[][] matrix) {

        int row = matrix.length;
        int cols = matrix[0].length;

        int[] height = new int[cols];
        int maxArea = 0;

        // Convert each matrix row into a histogram
        for (int r = 0; r < row; r++) {

            for (int c = 0; c < cols; c++) {

                if (matrix[r][c] == '1') {
                    height[c]++;
                } else {
                    height[c] = 0;
                }
            }

            // Find maximum rectangle for current histogram
            maxArea = Math.max(maxArea, maxAreaOfHistogram(height));
        }

        return maxArea;
    }

    private int maxAreaOfHistogram(int[] height) {

        Stack<Integer> st = new Stack<>();

        int n = height.length;

        int[] nse = new int[n];
        int[] pse = new int[n];

        int maxArea = 0;

        // Next Smaller Element (NSE)
        for (int i = n - 1; i >= 0; i--) {

            while (!st.empty() && height[st.peek()] >= height[i]) {
                st.pop();
            }

            nse[i] = st.empty() ? n : st.peek();

            st.push(i);
        }

        st.clear();

        // Previous Smaller Element (PSE)
        for (int i = 0; i < n; i++) {

            while (!st.empty() && height[st.peek()] >= height[i]) {
                st.pop();
            }

            pse[i] = st.empty() ? -1 : st.peek();

            st.push(i);
        }

        // Calculate maximum rectangle area
        for (int i = 0; i < n; i++) {

            int width = nse[i] - pse[i] - 1;

            int area = height[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}