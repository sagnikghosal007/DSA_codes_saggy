class Solution {
    public int josephus(int n, int k) {
        // code here
        ArrayList<Integer> ans =new ArrayList<>();
        int idx=0;
        int currIdx=0;
        for(int i=1;i<=n;i++){
            ans.add(i);
        }
        while(ans.size()>1){
            idx=(currIdx+k-1)%ans.size();
            currIdx=idx;
            ans.remove(idx);
        }
        return ans.get(0);
        
    }
}
//solution with TC:O(n) SC:O(1)

class Solution
{
   public int josephus(int n, int k)
    {
        //Your code here
        int win=0;
        for(int i=1;i<=n;i++){
            win = (win+k)%i;
        }
        return win+1;
    
    }

}
//using recursion 
class Solution
{
    
    public int winner( int n, int k ) {
        if(n == 1) return  0  ; 
        
        int ans = (winner(n-1, k)+k )%n ; 
        return ans ; 
        
        
    }
   public int josephus(int n, int k)
    {
       int won =  winner(n , k )+1; 
       
       return won; 
       
    }

}
