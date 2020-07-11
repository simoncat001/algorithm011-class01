class Solution {
    List <List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n==0||k==0||n<k){
            return result;
        }
        helper(0, n, k, new Stack<>());
        return result;
    }

    private void helper(int current, int n, int k, Stack<Integer> temp){
        if(temp.size()==k){
            List<Integer> t_result = new ArrayList<>(temp);
            result.add(t_result);
            return;
        }
        //这一步骤是在剪枝
        int tempEnd = n-(k-temp.size())+1;
        for(int i = current+1; i<=tempEnd; i++){
            temp.push(i);
            helper(i, n, k, temp);
            temp.pop();
        }
    }
}