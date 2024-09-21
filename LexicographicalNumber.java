class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans= new ArrayList<>();
        for(int start=1;start<=9;start++){
            solve(start,n,ans);
        }
        return ans;
    }
    private void solve(int currNum, int n ,List<Integer> ans){
        if(currNum>n) return;
        ans.add(currNum);
        for(int append=0;append<=9;append++){
            int newNum=(currNum*10)+append;
            if(newNum>n) return;
            solve(newNum,n,ans);
        }
    }
}
