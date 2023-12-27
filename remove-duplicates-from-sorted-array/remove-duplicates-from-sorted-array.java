class Solution {
    public int removeDuplicates(int[] nums) {
        int lastId = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[lastId] != nums[i]) {
                lastId++;
                nums[lastId] = nums[i];
            }
        }
        
        return lastId + 1;
    }
}