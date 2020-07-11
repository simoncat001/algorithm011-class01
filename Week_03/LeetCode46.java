class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backTracking(res, nums, new ArrayList<Integer>(), visited);
        return res;
    }

    private void backTracking(List<List<Integer>> res, int[] nums, List<Integer> temp, int[] visted){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(visted[i] == 1){
                continue;
            }
            visted[i]=1;
            temp.add(nums[i]);
            backTracking(res, nums, temp, visted);
            temp.remove(temp.size()-1);
            visted[i]=0;
        }
    }
}