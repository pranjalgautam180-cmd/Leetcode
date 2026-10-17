class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        // int n = nums.length;
        // int ans[] = new int [n];

        // for(int i=0; i<n; i++){
        //     ans[i] = -1;
        //     for(int j = 1; j < n; j++){
        //         int idx = (i+j)%n;
        //         if(nums[idx] > nums[i]){
        //             ans[i] = nums[idx];
        //             break;
        //         }
        //     }
        // }
        // return ans;

        Stack<Integer> st = new Stack<>();

        int n = nums.length;
        int nge[]  = new int [n];

        for(int i = 2*n - 1; i>=0 ;i--){
            while(!st.isEmpty() && st.peek() <= nums[i % n]){
                st.pop();
            }
            if(i < n){
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums[i % n]);
        }
        return nge;
    }
}