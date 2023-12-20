class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (node == destination) {
                return true;
            }
            if (seen[node]) {
                continue;
            }
            seen[node] = true;
            for (int neighbour: adj.get(node)) {
                stack.add(neighbour);
            }
        }
        
        return false;
    }
}