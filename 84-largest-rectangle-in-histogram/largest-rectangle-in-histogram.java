class Solution {
    public int largestRectangleArea(int[] heights) {
        
        // int n = heights.length;
        // int maxArea = Integer.MIN_VALUE;

        // for(int i=0; i<n; i++){
        //     int minHeight = Integer.MAX_VALUE;
        //     for(int j=i; j<n; j++){
        //         minHeight = Math.min(minHeight , heights[j]);
        //         int width = j-i+1;
        //         int area = minHeight * width;
        //         maxArea = Math.max(maxArea , area);
        //     }
        // }
        // return maxArea;

        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int maxArea = 0;

        for(int i=0; i<n; i++){
            while(!st.empty() && heights[st.peek()] > heights[i]){
                int element = st.peek();
                st.pop();
                int nse = i , pse = st.empty() ? -1 : st.peek();
                maxArea = Math.max(maxArea , (nse - pse -1)*heights[element]);
            }
            st.push(i);
        }
        while(!st.empty()){
            int nse = n;
            int element = st.peek();
            st.pop();
            int pse = st.empty() ? -1 : st.peek();
            maxArea = Math.max(maxArea , (nse-pse-1)*heights[element]);
        }
        return maxArea;
    }
}