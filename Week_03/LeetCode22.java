class Solution {

    public List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();
        List<String> result = new ArrayList<>();
        if(n==0){
            return result;
        }
        bt(result, builder, 0, 0, n);
        return result;
    }

    private void bt(List<String> result, StringBuilder builder, int left, int right, int n){
        if(left==n && right==n){
            result.add(builder.toString());
            return;
        }
        if(left>n){
            return;
        }
        if(right>left){
            return;
        }
        builder.append('(');
        bt(result, builder, left+1, right, n);
        builder.deleteCharAt(builder.length()-1);
        builder.append(')');
        bt(result, builder, left, right+1, n);
        builder.deleteCharAt(builder.length()-1);
    }
}