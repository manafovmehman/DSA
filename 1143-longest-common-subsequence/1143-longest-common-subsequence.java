class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
          for (int j = 0; j < text2.length(); j++) {
            memo[i][j] = -1;
          }
        }
        return rec(0, 0, text1, text2);
    }
    
    private int rec(int i, int j, String s, String t) {
        if (i == s.length() || j == t.length()) {
            return 0;
        }
        
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        if (s.charAt(i) == t.charAt(j)) {
            return 1 + rec(i + 1, j + 1, s, t);
        }
        
        
        memo[i][j] = Math.max(rec(i, j + 1, s, t), rec(i + 1, j, s, t));
        
        return memo[i][j];
    }
}