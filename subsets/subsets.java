class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num: nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> copy = new ArrayList<>(result.get(i));
                copy.add(num);
                result.add(copy);
            }
        }

        return result;
    }
}