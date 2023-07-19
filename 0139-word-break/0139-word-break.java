class Solution {
    private Map<Integer, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }
    
    private boolean dfs(String s, List<String> wordDict, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        if (i == s.length()) {
            return true;
        }
        
        for (String word: wordDict) {
            if (
                i + word.length() <= s.length() &&
                word.equals(s.substring(i, i + word.length()))
            ) {
                boolean res = dfs(s, wordDict, i + word.length());
                memo.put(i, res);
                if (res) {
                    return true;
                }
            }
        }
        
        return false;
    }
}