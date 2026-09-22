class Solution {
    public int[] sortedSquares(int[] nums) {

        int left = 0;
        int right = nums.length-1;
        int result[] = new int[nums.length];
        int idx = nums.length-1;

        while(left <= right){
            if(nums[left] * nums[left] < nums[right] * nums[right]){
                result[idx] = nums[right] * nums[right];
                right--;
            }
            else{
                result[idx] = nums[left] * nums[left];
                left++;
            }
            idx--;
        }
        return result;
    }
}
