class Solution {
    public int search(int[] nums, int target) {
        int pivot = findMinElement(nums);
        int res = binarySearch(nums, target, 0, pivot - 1);
        if (res == -1) {
            res = binarySearch(nums, target, pivot, nums.length - 1);
        }

        return res;
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return -1;
    }

    private int findMinElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}