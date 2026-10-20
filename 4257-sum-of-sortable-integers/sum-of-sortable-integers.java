
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        // Try every divisor k of n
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean sortable = true;
            int prevMax = Integer.MIN_VALUE;

            // Divide array into blocks of size k
            for (int start = 0; start < n; start += k) {
                int end = start + k;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                int descents = 0;

                for (int i = start; i < end; i++) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);

                    // Count descents inside the block
                    if (i > start && nums[i - 1] > nums[i]) {
                        descents++;
                    }
                }

                // Include the circular last-to-first comparison
                if (nums[end - 1] > nums[start]) {
                    descents++;
                }

                // Block must be sortable by cyclic rotation
                if (descents > 1) {
                    sortable = false;
                    break;
                }

                // Sorted blocks must also be in global order
                if (prevMax > min) {
                    sortable = false;
                    break;
                }

                prevMax = max;
            }

            if (sortable) {
                ans += k;
            }
        }

        return ans;
    }
}
