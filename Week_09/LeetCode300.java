class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        int [] dp = new int[nums.length];
        for(int num : nums){
            int i = Arrays.binarySearch(dp,0, len, num);
            if(i<0){
                i = -(i+1);
            }
            dp[i] = num;
            if(i==len){
                len++;
            }
        }
        return len;
    }
}