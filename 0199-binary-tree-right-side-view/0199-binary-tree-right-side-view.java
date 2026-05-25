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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> al= new ArrayList<>();
        rightdfs(root,al,0);
        return al;
        
    }
   public void rightdfs(TreeNode node,ArrayList<Integer>al, int level){
    if(node== null){return;}
    if(al.size()==level){al.add(node.val);}
    rightdfs(node.right, al,level+1);
    rightdfs(node.left,al,level+1);
   }

}