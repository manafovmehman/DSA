class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> memo = new HashMap<>();
        return dfs(s, 0, wordDict, memo);
    }

    private boolean dfs(String s, int i, List<String> wordDict, Map<Integer, Boolean> memo) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        if (i == s.length()) {
            return true;
            
        }
        if (i > s.length()) {
            return false;
        }
        for (String word: wordDict) {
            if (i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))) {
                Boolean result = dfs(s, i + word.length(), wordDict, memo);
                memo.put(i, result);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }
}