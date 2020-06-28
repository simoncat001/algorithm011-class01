class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length-1;
        int plus = 1;
        for(int i=n; i>=0; i--) {
            digits[i] = digits[i] + 1;
            digits[i] = digits[i] % 10;
            if(digits[i]!=0){
                return digits;
            }
        }
        // all 9
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}