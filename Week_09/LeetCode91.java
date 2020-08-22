class Solution {
    public int numDecodings(String s) {
        if(s.isEmpty() || s.startsWith("0")) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        int last = 0;
        int curr = 1;
        int first = s.charAt(0) - '0';
        int second = s.charAt(1) - '0';
        int result = 10*first + second;
        if(result > 26) {
            if(result%10 == 0) {
                return 0;
            } else {
                last = 1;
                curr = 1;
            }
        } else {
            last = 1;
            if(result%10 == 0) {
                curr = 1;
            } else {
                curr = 2;
            }
        }
        int i = 2;
        while(i < s.length()){
            char c = s.charAt(i);
            char l = s.charAt(i-1);
            if(c == '0'){
                if(c2int(l)==0 || c2int(l)>2){
                    return 0;
                } else {
                    int temp = last;
                    last = curr;
                    curr = temp;
                }
            } else {
                int temp_count = c2int(l)*10 + c2int(c);
                if(temp_count<=26 && temp_count>10){
                    int temp = last;
                    last = curr;
                    curr += temp;
                } else {
                    last = curr;
                }
            }
            i++;
        }
        return curr;
    }
    
    public int c2int(char c){
        return c-'0';
    }
}
