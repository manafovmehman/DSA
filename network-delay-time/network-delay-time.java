class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<Pair<Integer, Integer>>> adj = new HashMap<>();
        int[] signals = new int[n + 1];
        Arrays.fill(signals, Integer.MAX_VALUE);
        Set<Integer> visited = new HashSet<>();
        for (int[] time: times) {
            adj.putIfAbsent(time[0], new ArrayList<>());
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }
        signals[k] = 0;
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        pq.add(new Pair(k, 0));
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> top = pq.poll();
            Integer node = top.getKey();
            Integer time = top.getValue();
            visited.add(node);
            if (time > signals[node]) {
                continue;
            }
            if (adj.get(node) == null) {
                continue;
            }
            for (Pair<Integer, Integer> neighbour: adj.get(node)) {
                int t = neighbour.getValue() + time;
                if (!visited.contains(neighbour.getKey()) && t < signals[neighbour.getKey()]) {
                    signals[neighbour.getKey()] = t;
                    pq.add(new Pair(neighbour.getKey(), t));
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, signals[i]);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}