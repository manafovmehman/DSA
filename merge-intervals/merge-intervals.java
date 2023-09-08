class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                current = intervals[i];
                result.add(current);
            }
        }
        int[][] a = new int[5][];
        a[0] = new int[5];

        return result.toArray(new int[result.size()][]);
    }
}