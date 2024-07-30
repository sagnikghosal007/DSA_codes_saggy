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
    public List<Integer> take_ans(Map<Integer,List<Integer>> map,TreeNode node,int val){
        List<Integer> res=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        int target=node.val;
        q.add(target);
        if(val==0) return new ArrayList(Arrays.asList(target));
        while(!q.isEmpty()){
            int size=q.size();
            boolean b=true;
            while(size-->0){
                int curr_Node=q.poll();
                if(map.get(curr_Node)!=null){
                for(Integer ele:map.get(curr_Node)){
                        if(!set.contains(ele)){
                        if(val==1){
                            res.add(ele);
                            b=false;
                    }
                    set.add(curr_Node);
                    q.add(ele);
                }
            }
        }
    }
    if(b==false) return res;
    --val;
    }
     return res;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Map<Integer,List<Integer>>map=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode node=q.poll();
                int val=node.val;
                if(node.left!=null){
                    q.add(node.left);
                map.putIfAbsent(val,new ArrayList<>());
                map.putIfAbsent(node.left.val,new ArrayList<>());
                map.get(val).add(node.left.val);
                map.get(node.left.val).add(val);
                }
                
                if(node.right!=null){
                    q.add(node.right);
                map.putIfAbsent(val,new ArrayList<>());
                map.putIfAbsent(node.right.val,new ArrayList<>());
                map.get(val).add(node.right.val);
                map.get(node.right.val).add(val);
                }
            }
        }
        return take_ans(map,target,k);
     }
}
