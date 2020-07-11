class Solution {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int[] preorder;
    int[] inorder;
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        this.preorder = preorder;
        for(int i = 0; i < preorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(0, inorder.length-1);
    }

    public TreeNode helper(int start, int end){
        int rootVal = preorder[index];
        index++;
        TreeNode root = new TreeNode(rootVal);
        int tempIndex = inorderMap.get(rootVal);
        if(tempIndex>start){
            root.left = helper(start, tempIndex-1);
        }
        if(tempIndex<end){
            root.right = helper(tempIndex+1, end);
        }
        return root;
    }
}
