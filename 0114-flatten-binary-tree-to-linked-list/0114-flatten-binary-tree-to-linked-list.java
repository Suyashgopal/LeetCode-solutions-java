/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {

ArrayList<TreeNode> al = new ArrayList<>();
if(root==null){
    return ;
} 
preorder(root,al);
int i=0;
int j=1;
while(j<al.size()){
    TreeNode node= al.get(i);
    TreeNode n2= al.get(j);
    node.right= n2;
    node.left= null;
    i=j;
    j++;
}
        
    }
    void preorder(TreeNode root,ArrayList<TreeNode> al)
    {
        if(root==null){return;}
        al.add(root);
        preorder(root.left,al);
        preorder(root.right,al);

    }
}