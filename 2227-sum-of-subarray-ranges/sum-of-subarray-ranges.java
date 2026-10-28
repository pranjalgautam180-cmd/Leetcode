class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        Stack<Integer> st = new Stack<>();

        // 1. Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (!st.empty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            leftMin[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // 2. Next Smaller or Equal Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            rightMin[i] = st.empty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        // 3. Previous Greater Element
        for (int i = 0; i < n; i++) {
            while (!st.empty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            leftMax[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // 4. Next Greater or Equal Element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            rightMax[i] = st.empty() ? n : st.peek();
            st.push(i);
        }

        long sumMax = 0;
        long sumMin = 0;

        // 5. Calculate contributions
        for (int i = 0; i < n; i++) {
            long maxCount = (long) (i - leftMax[i]) * (rightMax[i] - i);

            long minCount = (long) (i - leftMin[i]) * (rightMin[i] - i);

            sumMax += nums[i] * maxCount;
            sumMin += nums[i] * minCount;
        }

        return sumMax - sumMin;
    }
}