class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int left = 0;
        int right = 0;
        int maxlength = 0;
        for(int i = 0; i<len; i++) {
            if(s.charAt(i)=='('){
                left ++;
            } else {
                right ++;
            }
            if(right>left) {
                left = right = 0;
            } else if(left==right) {
                maxlength = Math.max(maxlength, 2 * right);
            }
        }
        left = 0;
        right = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}