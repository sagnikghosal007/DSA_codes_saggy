//Jump Game 1 
//chasing the goal approach and return goal==0
Class Solution {
  public int jump(int[] nums)
    {
    int n=nums.length;
    //initialize the goal aa the last index as given by the question
    int gaol=n-1;
    for(int i=n-2;i>=0;i--)
    {

      // curr index + nums[curr index] >= goal 
      //if true then assign your goal to the current index and move backwards
      if(i+nums[i]>=goal){
        goal=i;
      }
    }
    return goal=0;
  }
}
      

//Jump game 2
//two pointer approach 
class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int l=0,r=0,jumps=0;
        while(r<n-1){
            int farthest=0;
            for(int i=l;i<=r;i++){
                farthest=Math.max(i+nums[i],farthest);
            }
            l=r+1;
            r=farthest;
            jumps++;

        }

        return jumps;

    }
}
