class Solution {

    static int pivotElement(int[] nums) { // To find the pivot element about which array directon changes

        int n = nums.length;
        int s = 0;
        int e = n - 1;
        int ans = -1;

        // Array is already sorted
        if (nums[s] < nums[e]) {
            return -1;
        }

        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (nums[mid] <= nums[n - 1]) {
                e = mid - 1;
            } 
            else {
                ans = mid;
                s = mid + 1;
            }
        }

        return ans;
    }

    static int binarySearch(int[] nums, int s, int e, int target) { // this is used if array return -1

        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            else if (target > nums[mid]) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {

        int pivot = pivotElement(nums);
        int n = nums.length;

        // Array is already sorted
        if (pivot == -1) {
            return binarySearch(nums, 0, n - 1, target);
        }

        // First sorted part: 0 -> pivot
        if (target >= nums[0] && target <= nums[pivot]) {
            return binarySearch(nums, 0, pivot, target);
        }

        // Second sorted part: pivot+1 -> n-1
        if (target >= nums[pivot + 1] && target <= nums[n - 1]) {
            return binarySearch(nums, pivot + 1, n - 1, target);
        }

        return -1;
    }
}