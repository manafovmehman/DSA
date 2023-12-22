class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        Queue<List<Integer>> queue = new ArrayDeque<>();
        List<List<Integer>> adj = new ArrayList<>();
        queue.add(new ArrayList<>(Arrays.asList(new Integer[]{0})));
        while (!queue.isEmpty()) {
            List<Integer> currentPath = queue.poll();
            Integer lastNode = currentPath.get(currentPath.size() - 1);
            if (lastNode == graph.length - 1) {
                paths.add(new ArrayList<>(currentPath));
            }
            for (int neighbour: graph[lastNode]) {
                List<Integer> tmp = new ArrayList<>(currentPath);
                tmp.add(neighbour);
                queue.add(tmp);
            }
        }
        
        return paths;
    }
}