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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> al= new ArrayList<>();

        Stack<TreeNode> st= new Stack<>();
        TreeNode curr= root;
           TreeNode temp;
      while(!st.isEmpty() || curr!= null){
        if(curr!= null){
            st.push(curr);
            curr= curr.left;

        }
        else{
            temp= st.peek().right;
            if(temp==null){
                temp= st.pop();
                al.add(temp.val);
                while(!st.isEmpty() && temp== st.peek().right){
                    temp= st.pop();
                    al.add(temp.val);
                }


            }
            else{
                curr= temp;
            }
        }
      }
      return al;
        
    }
}