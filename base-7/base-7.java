class Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        List<String> result = new ArrayList<>();
        int sign = 1;
        if (num < 0) {
            num *= -1;
            sign = -1;
        }
        while (num != 0) {
            result.add(String.valueOf(num % 7));
            num /= 7;
        }
        if (sign == -1) {
            result.add("-");
        }
        Collections.reverse(result);
        
        return String.join("", result);
    }
}