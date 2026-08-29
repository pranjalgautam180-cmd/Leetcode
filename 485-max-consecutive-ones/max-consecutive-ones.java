class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int ans = 0;
        int count = 0;

        for(int j=i; j<nums.length; j++){
            if(nums[j] == 1){
                count++;
                ans = Math.max(ans , count);
            }else{
                count = 0;
            }
        }
        return ans;
    }
}