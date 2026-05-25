class Solution {

    class pair {
        TreeNode node;
        int id;

        pair(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) return 0;

        int maximum = 0;

        Queue<pair> q = new LinkedList<>();

        q.add(new pair(root, 0));

        while (!q.isEmpty()) {
         int size= q.size();
         int first=0;
         int last=0;
         for(int i=0;i<size;i++){
            pair curr= q.poll();
            TreeNode node= curr.node;
            int id= curr.id;
            if(i==0){
            first=id;
            }
            if(i== size-1){
                last=id;
            }
            if(node.left!= null){
                q.add(new pair(node.left, 2*id));
            }
            if(node.right!= null){
                q.add(new pair(node.right,2*id+1));
            }
         }
           maximum= Math.max(maximum, last- first+1);

          
        }

        return maximum;
    }
}