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
        if(node==null)return null;
        Map<Integer,Node> map=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        Node head=new Node(node.val);
        map.put(node.val,head);
        q.add(node);
        while(q.size()>0){
            Node poll=q.poll();
            Node dummy=map.get(poll.val);
            List<Node> neig=new ArrayList<>();
            for(Node n:poll.neighbors){
                if(map.containsKey(n.val)){
                    neig.add(map.get(n.val));
                }
                else{
                    Node news=new Node(n.val);
                    map.put(n.val,news);
                    neig.add(news);
                    q.add(n);
                }
            }
            dummy.neighbors=neig;
        }
        return head;
    }
}
