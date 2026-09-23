class Solution {
    public int minOperations(int[] nums, int x) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        // If target is negative,
        // impossible to keep such a subarray.
        if (target < 0) {
            return -1;
        }

        int left = 0;
        int sum = 0;
        int maxLength = -1;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (left <= right && sum > target) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                maxLength = Math.max(
                    maxLength,
                    right - left + 1
                );
            }
        }

        if (maxLength == -1) {
            return -1;
        }

        return nums.length - maxLength;
    }
}