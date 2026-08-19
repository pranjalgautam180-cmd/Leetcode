class Solution {
        static boolean isValidSum(int nums[], int k, int maxSum) {

        int splitSum = 1;
        int largestSum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (largestSum + nums[i] <= maxSum) {
                largestSum += nums[i];
            } 
            else {
                splitSum++;

                if (splitSum > k || nums[i] > maxSum) {
                    return false;
                }
                largestSum = nums[i];
            }
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        
        int sum = 0;
        int s = 0;

        for (int num : nums) {
            sum += num;
            s = Math.max(s, num);
        }

        int e = sum;
        int ans = -1;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (isValidSum(nums, k, mid)) {
                ans = mid;
                e = mid - 1;
            } 
            else {
                s = mid + 1;
            }
        }
        return ans;
    }
}