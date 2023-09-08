class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        for (int num: nums1) nums1Set.add(num);
        Set<Integer> result = new HashSet<>();
        for (int num: nums2) {
            if (nums1Set.contains(num)) {
                result.add(num);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}