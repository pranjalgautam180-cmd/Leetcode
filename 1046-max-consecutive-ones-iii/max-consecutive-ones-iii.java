class Solution {
    public int longestOnes(int[] nums, int k) {

        int n = nums.length;
        int maxlen = 0;

        for(int i = 0; i<n; i++){
            int zeroes = 0;
            for(int j =i; j<n; j++){
                if(nums[j] == 0){
                    zeroes++;
                }
                if(zeroes <= k){
                    maxlen = Math.max(maxlen, j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return maxlen;
    }
}