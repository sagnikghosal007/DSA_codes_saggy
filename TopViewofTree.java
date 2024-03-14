
/*class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/
class Pair{
    int column_level;
    Node node;
    Pair(Node node, int column_level)
    {
        this.column_level=column_level;
        this.node=node;
    }
}
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        //ordered map er kaaj korbe 
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q= new LinkedList<Pair>();
        q.add(new Pair(root,0));
        while(!q.isEmpty())
        {
            Pair it= q.remove();
            int column_level=it.column_level;
            Node node=it.node;
            if(map.get(column_level)==null){
                map.put(column_level,node.data);
            }
            else
            {
                ;
            }
            if(node.left!=null){
                q.add(new Pair(node.left,column_level-1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right,column_level+1));
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
