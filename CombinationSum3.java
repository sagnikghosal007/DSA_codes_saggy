/*
  Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
*/

//solution 1
class Solution {
    private void f(int ind , int k, int n,  List<List<Integer>> ans ,List<Integer> ds){
        //base case
        if(k==0 && n==0){
            ans.add(ds);
            return;
        }
        if(ind>9) return;
        if(k<0 || n<0) return;

        List<Integer> temp=new ArrayList<>(ds);
        temp.add(ind);
        //pick 
        f(ind+1,k-1,n-ind,ans,temp);
        //not pick
        f(ind+1,k,n,ans,ds);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        f(1,k,n,ans,new ArrayList<>());
        return ans;
    }
}

//solution 2
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(1, k, n, temp, ans);
        return ans;
        
    }

    private void backtrack(int idx, int k, int target, List<Integer> temp, List<List<Integer>> ans) {

        if(target<0) return;

        if (temp.size() == k && target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i <= 9; i++) {
            temp.add(i);
            backtrack(i + 1, k, target - i, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

}
