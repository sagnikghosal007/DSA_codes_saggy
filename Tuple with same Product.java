class Solution {
    public int tupleSameProduct(int[] nums) {
        int n=nums.length;
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                map.put(nums[j]*nums[i],map.getOrDefault(nums[j]*nums[i],0)+1);
            }
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>=2){
                //get the count of pairs with the same product
                int e=entry.getValue();

                //calculating the number of valid tuples
                //no of tupes= 2^n-1 =2^3 (n=4) =8
                //ncr = nc2=(n*(n-1))/2
                //ans+=4*(e*(e-1));

            }
        }

        return ans ;


        //earki marchilam return (int)Math.pow(2,n-1)*(n*(n-1)/2);
    }
}
