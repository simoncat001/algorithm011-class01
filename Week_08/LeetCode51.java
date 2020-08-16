class Solution {
    int size = 0;
    public List<List<String>> solveNQueens(int n) {
        size = ( 1 << n ) - 1;
        List<List<String>> result = new ArrayList<>();
        solve(result, new ArrayList<String>(), 0, 0, 0, n);
        return result;
    }
    
    private void solve(List<List<String>> result, List<String> res, int row, int ld, int rd, int n) {
        if(row == size) {
            result.add(new ArrayList<>(res));
        }
        int pos = size & ( ~( row | ld | rd ) );
        while(pos != 0) {
            int p = pos & ( -pos );
            pos -= p;
            res.add(buildString(p, n));
            solve(result, res, row | p, ( ld | p ) << 1, ( rd | p ) >> 1, n);
            res.remove(res.size()-1);
        }
    }
    
    private String buildString(int p, int n){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<n; i++) {
            if(((p >> i) & 1)==1){
                stringBuilder.append('Q');
            } else {
                stringBuilder.append('.');
            }
        }
        return stringBuilder.toString();
    }
}