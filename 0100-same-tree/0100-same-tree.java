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
    public boolean isSameTree(TreeNode p, TreeNode q) {
       Stack<TreeNode> st1= new Stack<>();
              Stack<TreeNode> st2= new Stack<>();
              if(q==null){
                if(p==null){
                    return true;
                }
                return false;
              }
              if(p==null){
                if(q==null){
                    return true;
                }
                return false;
              }

  st1.push(p);
  st2.push(q);
  while(true){
    TreeNode n1= st1.pop();
    TreeNode n2= st2.pop();
    if(n1.val!=n2.val){return false;}

    
     if(n1.right!= null){
        if(n2.right==null){return false;}
        st1.push(n1.right);
        st2.push(n2.right);
    }
  else  if(n2.right!=null&& n1.right== null){return false;}

    if(n1.left!= null){
        if(n2.left==null){return false;}
        st1.push(n1.left);
        st2.push(n2.left);
    }
     else  if(n2.left!=null&& n1.left== null){return false;}
     if(st1.isEmpty()|| st2.isEmpty()){
        break;
     }



  }
  return true;

    }

}