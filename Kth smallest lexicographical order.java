class Solution {
    private int count(long curr,long next,long n){
        int countNum=0;
        while(curr<=n){
            countNum+=next-curr;
            curr*=10;
            next*=10;
            next=Math.min(next,n+1);
        }
        return countNum;
    }
    public int findKthNumber(int n, int k) {
        long curr=1;
        k-=1;
        while(k>0){
            int countNum=count(curr,curr+1,n);
            if(countNum<=k){
                curr++;
                k-=countNum;
            }
            else{
                curr*=10;
                k-=1;
            }
        }
        return (int)curr;
    }
}
