/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //fill all the elements
        Queue<TreeNode> q= new LinkedList<>();
        HashMap<TreeNode,TreeNode> parent= new HashMap<>();
        List<Integer> list= new ArrayList<>();
        if(root== null){ return list;}
        q.offer(root);
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                TreeNode node= q.poll();
                if(node.left!= null){
                    parent.put(node.left,node);
                    q.offer(node.left);
                }
                if(node.right!=null){
                    parent.put(node.right, node);
                    q.offer(node.right);
                }
            }

        }
    int dist=1;
         Queue<TreeNode> q2= new LinkedList<>();
                  Queue<TreeNode> visited= new LinkedList<>();

        
         q2.add(target);
         visited.add(target);
         while(dist<=k){
            if(q2.isEmpty()){break;}
            int size= q2.size();
            for(int i=0;i<size;i++){
                TreeNode node2= q2.poll();

               if(node2.left!= null && !visited.contains(node2.left)){
                   q2.add(node2.left);
                   visited.add(node2.left);           
               }
               if(node2.right!= null && !visited.contains(node2.right)){
                q2.add(node2.right);
                visited.add(node2.right);
               }
               
                if(parent.containsKey(node2) && !visited.contains(parent.get(node2))){
                    q2.add(parent.get(node2));
                    visited.add(parent.get(node2));

                }
            }
           dist++;
         }
     
         while(!q2.isEmpty()){
            list.add(q2.poll().val);
         }
    return list;
    }
}