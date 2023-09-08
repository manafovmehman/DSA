class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return dfs(s, 0, memo);
    }

    private int dfs(String s, int i, int[] memo) {
        if (i == s.length()) {
            return 1;
        }
        if (i > s.length()) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int count = 0;
        for (int idx = i + 1; idx <= i + 2 && idx <= s.length(); idx++) {
            String part = s.substring(i, idx);
            int code = Integer.parseInt(part);
            if (part.charAt(0) != '0' && code >= 1 && code <= 26) {
                count += dfs(s, idx, memo);
            }
        }
        memo[i] = count;
        return count;
    }
}