class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0 || g.length==0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int number = 0;
        for(int i : s){
            if(number<g.length && i>=g[number]){
                number++;
            }
        }
        return number;
    }
}