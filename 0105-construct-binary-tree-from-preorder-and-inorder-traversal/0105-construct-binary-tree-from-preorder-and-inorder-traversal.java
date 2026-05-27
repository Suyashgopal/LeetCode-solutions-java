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
    public TreeNode buildTree(int[] pre, int[] in) {
        //put all in hashmap
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<in.length;i++){
            map.put(in[i], i);
        }
        return fun(pre, 0, pre.length-1, in, 0, in.length-1,map);
    }
TreeNode fun(int[] pre, int pst, int pend, int [] in, int inst, int inend, HashMap<Integer,Integer> map){
    if(pst>pend ||inst>inend){
        return null;
    }
    TreeNode root= new TreeNode(pre[pst]);
    int rootidx= map.get(root.val);
    int leftside= rootidx-inst;
    root.left= fun(pre,pst+1,pst+leftside, in,inst,rootidx-1,map);
    root.right= fun(pre, pst+leftside+1,pend,in,rootidx+1,inend,map);
    return root;
}
}