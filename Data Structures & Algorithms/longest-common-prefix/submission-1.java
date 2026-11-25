class Solution {
    public String in(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] arr = a.toCharArray();
        char[] brr = b.toCharArray();
        for(int i = 0; i < Math.min(arr.length, brr.length); i++) {
            if(arr[i] == brr[i]) sb.append(arr[i]);
            else break;
        }
        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        else if(strs.length == 1) return strs[0];
        else {
            if(strs.length == 2) return in(strs[0], strs[1]);
            else {
                String lc = in(strs[0], strs[1]);
                for(String s : strs) {
                    lc = in(lc, s);
                }
                return lc;
            }
        }
    }
}