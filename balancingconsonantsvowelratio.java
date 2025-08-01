class Solution {
    boolean isvowel(char ch)
    {
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u');
    }
    public int countBalanced(String[] arr) {
        // code here
        int n=arr.length;
        Map<Integer,Integer>mp=new HashMap<>();
        mp.put(0,1);
        int sum=0;
        int ans=0;
        for(String str:arr){
            int curr=0;
            for(char ch:str.toCharArray()){
                if(isvowel(ch)) curr++;
                else curr--;
            }
            sum+=curr;
            if(mp.containsKey(sum)) ans+=mp.get(sum);
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        
        return ans;
    }
}
