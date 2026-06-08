/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node== null){return null;}
    Queue<Node> q= new LinkedList<>();
    HashMap<Node,Node> map= new HashMap<>();
    Node st= new Node(node.val);
    q.add(node);
    map.put(node ,st);
    

      while(!q.isEmpty()){
        Node curr= q.poll();
        for(Node x : curr.neighbors){
            if(!map.containsKey(x)){
                map.put(x, new Node(x.val));
                q.add(x);
            }
            map.get(curr).neighbors.add(map.get(x));
        } }
      return st;
   
    }
}