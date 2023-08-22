class Solution {
    public String validIPAddress(String queryIP) {
        String[] parts = queryIP.split("\\.", -1);
        if (parts.length == 4) {
            for (String part: parts) {
                if (part.length() == 0 || part.length() > 3) return "Neither";
                if (part.charAt(0) == '0' && part.length() != 1) {
                    return "Neither";
                }
                for (char c: part.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        return "Neither";
                    }
                }
                if (Integer.parseInt(part) > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        }
        parts = queryIP.split(":", -1);
        if (parts.length == 8) {
            String hexdigits = "0123456789abcdefABCDEF";
            for (String part: parts) {
                if (part.length() == 0 || part.length() > 4) {
                    return "Neither";
                }
                for (char c: part.toCharArray()) {
                    if (hexdigits.indexOf(c) == -1) {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }
        return "Neither";
    }
}