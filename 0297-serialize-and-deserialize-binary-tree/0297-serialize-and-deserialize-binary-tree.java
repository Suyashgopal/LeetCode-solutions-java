/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null){
            return sb.toString();
        }
        q.offer(root);
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                TreeNode node= q.poll();
                if(node== null){sb.append("n,");}
                else{
                    int v= node.val;
                    sb.append(v).append(",");
                }
                
                if(node!= null){
                    q.offer(node.left);
                    q.offer(node.right);

                }

            }

        }
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){return null;}

         String[] arr = data.split(",");
        int n= arr.length;
        Queue<TreeNode> q= new LinkedList<>();
      TreeNode root= new TreeNode(Integer.valueOf(arr[0]));
      int ptr=1;
      q.offer(root);

      while(!q.isEmpty() ){

        TreeNode node= q.poll();
        //left
        if(!arr[ptr].equals("n")){
            TreeNode l= new TreeNode(Integer.valueOf(arr[ptr]));
            q.offer(l);
            node.left= l;
        }
                    ptr++;


    if(!arr[ptr].equals("n")){
            TreeNode r= new TreeNode(Integer.valueOf(arr[ptr]));
            q.offer(r);
            node.right= r;
        }
            ptr++;

        


      }
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));