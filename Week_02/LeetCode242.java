class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        int [] arr = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int len = s.length();
        for(int i = 0; i<len; i++){
            arr[sArr[i]-'a']++; 
        }
        for(int i = 0; i<len; i++){
            if( arr[tArr[i]-'a']<0){
                return false;
            }
            arr[tArr[i]-'a']--;
        }
        for(int i = 0; i<26;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}
