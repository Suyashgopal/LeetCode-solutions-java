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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> a1 = new ArrayList<>();
        ArrayList<TreeNode> a2 = new ArrayList<>();

        givepath(a1, p.val, root);
        givepath(a2, q.val, root);

        // getting the first common ancestor

        if (a1.contains(q)) {
            return q;
        }

        if (a2.contains(p)) {
            return p;
        }

        int i = a1.size() - 1;
        int j = a2.size() - 1;

        while (i >= 0 && j >= 0) {

            if (a1.contains(a2.get(j))) {
                return a2.get(j);
            }

            if (a2.contains(a1.get(i))) {
                return a1.get(i);
            }

            i--;
            j--;
        }

        while (i >= 0) {

            if (a2.contains(a1.get(i))) {
                return a1.get(i);
            }

            i--;
        }

        while (j >= 0) {

            if (a1.contains(a2.get(j))) {
                return a2.get(j);
            }

            j--;
        }

        return root;
    }

    boolean givepath(ArrayList<TreeNode> al, int target, TreeNode node) {

        if (node == null) {
            return false;
        }

        al.add(node);

        if (node.val == target) {
            return true;
        }

        if (givepath(al, target, node.left) ||
            givepath(al, target, node.right)) {

            return true;
        }

        al.remove(al.size() - 1);

        return false;
    }
}