class Solution {

    class pair {
        TreeNode node;
        long id;

        pair(TreeNode node, long id) {
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

            int size = q.size();

            long minid = q.peek().id;

            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {

                pair curr = q.remove();

                TreeNode node = curr.node;

                long id = curr.id - minid;

                if (i == 0) first = id;
                if (i == size - 1) last = id;

                if (node.left != null) {
                    q.add(new pair(node.left, 2 * id));
                }

                if (node.right != null) {
                    q.add(new pair(node.right, 2 * id + 1));
                }
            }

            maximum = Math.max(maximum, (int)(last - first + 1));
        }

        return maximum;
    }
}