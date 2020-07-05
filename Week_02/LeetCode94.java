/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();
        TreeNode ans = root;
        while(!nodeStack.isEmpty()||ans!=null){
            if(ans!=null){
                nodeStack.add(ans);
                ans = ans.left;
            } else {
                ans = nodeStack.pop();
                resultList.add(ans.val);
                ans = ans.right;
            }
        }
        return resultList;
    }
}
