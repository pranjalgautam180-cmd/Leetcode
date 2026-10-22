class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int nge[] = new int [nums.length];

        for(int i=0; i<nums.length; i++){
            nge[i]  = -1;
            for(int j= 1; j<nums.length; j++){

                int idx = (i+j) % nums.length;
                
                if(nums[idx] > nums[i]){
                    nge[i] = nums[idx];
                    break;
                }
            }
        }
        return nge;
    }
}