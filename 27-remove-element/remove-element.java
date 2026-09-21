class Solution {
    public int removeElement(int[] nums, int val) {

        // Count how many times val occurs
        int count = 0;

        for (int num : nums) {
            if (num == val) {
                count++;
            }
        }

        // Resultant array size
        int k = nums.length - count;

        // New array
        int[] result = new int[k];

        int index = 0;

        // Copy elements except val
        for (int num : nums) {
            if (num != val) {
                result[index] = num;
                index++;
            }
        }

        // result contains the answer
        for (int i = 0; i < k; i++) {
            nums[i] = result[i];
        }

        return k;
    }
}