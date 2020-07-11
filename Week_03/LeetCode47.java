class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rest = new ArrayList();
        Arrays.sort(nums);
        for(int x: nums){
            rest.add(x);
        }
        permuteUniqueBt(result, rest, new ArrayList<>());
        return result;
    }

    public void permuteUniqueBt(List<List<Integer>> result, List<Integer> rest, List<Integer> cur){
        if (rest.size()==0){
            result.add(cur);
        }else {
            for(int x = 0; x<rest.size(); x++){
                if(x>0 && rest.get(x)==rest.get(x-1)){
                    continue;
                }
                List<Integer> arr = new LinkedList<>(rest);
                arr.remove(x);
                List<Integer> curList = new ArrayList<>(cur);
                curList.add(rest.get(x));
                permuteUniqueBt(result, arr, curList);
            }
        }
    }
}

//解法2 不需要visted
class Solution02{
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> rest = new ArrayList();
        for(int x: nums){
            rest.add(x);
        }
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, rest, new ArrayList<>());
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> rest, List<Integer> temp) {
        if(rest.size()==0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int x = 0; x<rest.size(); x++){
            if(x>0 && rest.get(x)==rest.get(x-1)){
                continue;
            }
            List<Integer> arr = new LinkedList<>(rest);
            arr.remove(x);
            List<Integer> curList = new ArrayList<>(temp);
            curList.add(rest.get(x));
            backTrack(result, arr, curList);
        }

    }
}