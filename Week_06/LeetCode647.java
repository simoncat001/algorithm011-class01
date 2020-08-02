class Solution {
    public int countSubstrings(String s) {
        List<Character> list = new ArrayList<>();
        list.add('$');
        for(char x: s.toCharArray()){
            list.add('#');
            list.add(x);
        }
        list.add('#');
        list.add('*');
        int [] Z = new int[list.size()];
        int center = 0;
        int right = 0;
        for (int i = 1; i < list.size() - 1; ++i) {
            if (i < right){
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            }
            while (list.get(i + Z[i] + 1).equals(list.get(i - Z[i] - 1))) {
                Z[i]++;
            }
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v: Z){
            ans += (v + 1) / 2;
        }
        return ans;
    }
}