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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> outer= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null){
            return outer;
        }
        q.offer(root);
        int count=0;
        while(!q.isEmpty()){
            int n= q.size();
            ArrayList<Integer> li= new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node= q.poll();
                if(node.left!= null){ q.offer(node.left);}
                 if(node.right!= null){ q.offer(node.right);}
                 li.add(node.val);

            }
            if (count%2!=0){//reverse 
            Collections.reverse(li);
            }
            count++;
            outer.add(li);

        }
        return outer;
        
    }
}