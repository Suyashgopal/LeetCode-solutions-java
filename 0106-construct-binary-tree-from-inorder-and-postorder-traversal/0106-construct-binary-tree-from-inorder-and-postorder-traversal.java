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
    public TreeNode buildTree(int[] in, int[] post) {
        int n= in.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(in[i],i);
        }


       return  fun(in, 0, n-1, post, 0, n-1,map);
         
    }

    TreeNode fun(int[] in , int inst, int inend, int[] post, int pst, int pend, HashMap<Integer,Integer> map){
        if(pst>pend || inst>inend){return null;}
        TreeNode root= new TreeNode(post[pend]);
        int rootidx= map.get(root.val);
        int rightside= inend- rootidx;
               
                root.right= fun(in , rootidx+1, inend, post,pend-rightside, pend-1,map);


        root.left= fun(in, inst, rootidx-1, post,pst, pend-rightside-1, map);
        return root;
    }
}