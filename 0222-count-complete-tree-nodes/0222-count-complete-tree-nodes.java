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
    public int countNodes(TreeNode root) {
        
                Queue<TreeNode> q= new LinkedList<>();
                ArrayList<TreeNode> al= new ArrayList<>();

        if(root==null){return 0;}

        q.offer(root);
        while(true){
            TreeNode node= q.poll();
            al.add(node);
             if(node.left==null){
                break;
            }
            else{
                q.add(node.left);
            }
            if(node.right==null){
                break;
            }
            else{
                q.add(node.right);
            }

        }
        return al.size()+ q.size();
    }
}