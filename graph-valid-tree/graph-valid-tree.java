class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] pair: edges) {
            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        }

        return dfs(0, -1, adj, seen) && n == seen.size();
    }

    private boolean dfs(int i, int prev, Map<Integer, List<Integer>> adj, Set<Integer> seen) {
        if (seen.contains(i)) {
            return false;
        }
        seen.add(i);
        for (int neighbour: adj.get(i)) {
            if (neighbour != prev) {
                if (!dfs(neighbour, i, adj, seen)) {
                    return false;
                }
            }
        }

        return true;
    }
}