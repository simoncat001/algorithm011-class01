class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    public boolean valid(TreeNode root, Integer bot, Integer top) {
        if(root==null){
            return true;
        }
        int val = root.val;
        if (top != null && top <= val) {
            return false;
        }
        if (bot != null && bot >= val) {
            return false;
        }
        return valid(root.left, bot, val) && valid(root.right, val, top);
    }
}


class Solution2 {
    //解法二，二叉搜索树的中序遍历一定是递增的。
    public boolean isValidBST(TreeNode root) {
        //中序遍历
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode curr = root;
        Integer last = null;
        while (curr != null || !nodeStack.isEmpty()) {
            while (curr != null){
                nodeStack.push(curr);
                curr = curr.left;
            }
            curr = nodeStack.pop();
            if(last!=null && curr.val <= last){
                return false;
            } else {
                last = curr.val;
            }
            curr = curr.right;
        }
        return true;
    }
}