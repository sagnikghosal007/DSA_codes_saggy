class Solution {
    public int[] convertToNewSystem(int[] mapping, int[] nums){
        int n=nums.length;
        int[] newSys=new int[n];
        for(int j=0;j<n;j++){
            int num=nums[j];
            if(num==0){
                newSys[j]=mapping[0];
                continue;
            }
            int i=0;
            int ans=0;
            while(num>0){
                int d=num%10;
                int newD=mapping[d];
                ans=newD*(int)Math.pow(10,i) + ans;
                num=num/10;
                i++;
            }
            newSys[j]=ans;
        }
        return newSys;
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n=nums.length;
        int[] newSys=convertToNewSystem(mapping,nums);
        Integer index[]=new Integer[n];
        for(Integer i=0;i<n;i++){
            index[i]=i;
        }
        Arrays.sort(index,new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                //inc order
                return newSys[a]-newSys[b];
            }
        });
        int res[] = new int[n];
        int i=0;
        for(int ind:index){
            res[i]=nums[ind];
            i++;
        }
        return res;
    }
}
