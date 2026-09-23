// class Solution {
//     public int minOperations(int[] nums, int x) {

//         int total = 0;

//         for (int num : nums) {
//             total += num;
//         }

//         int target = total - x;

//         // If target is negative,
//         // impossible to keep such a subarray.
//         if (target < 0) {
//             return -1;
//         }

//         int left = 0;
//         int sum = 0;
//         int maxLength = -1;

//         for (int right = 0; right < nums.length; right++) {

//             sum += nums[right];

//             while (left <= right && sum > target) {
//                 sum -= nums[left];
//                 left++;
//             }

//             if (sum == target) {
//                 maxLength = Math.max(
//                     maxLength,
//                     right - left + 1
//                 );
//             }
//         }

//         if (maxLength == -1) {
//             return -1;
//         }

//         return nums.length - maxLength;
//     }
// }
class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        // Calculate total sum
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;

        // If target is negative, impossible
        if (target < 0) {
            return -1;
        }

        // If target is 0, we need to remove all elements
        if (target == 0) {
            return n;
        }

        int left = 0;
        int sum = 0;
        int maxLength = -1;

        // Sliding window
        for (int right = 0; right < n; right++) {
            sum += nums[right];

            // Shrink window if sum becomes too large
            while (sum > target) {
                sum -= nums[left];
                left++;
            }

            // Found a subarray with target sum
            if (sum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        // If no valid subarray exists
        if (maxLength == -1) {
            return -1;
        }

        return n - maxLength;
    }
}