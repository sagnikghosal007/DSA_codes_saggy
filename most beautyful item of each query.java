class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items,Comparator.comparingInt(a -> a[0]));
        int maxbeauty=Integer.MIN_VALUE;
        List<int[]> res=new ArrayList<>();
        res.add(new int[] {0,0,maxbeauty});
        for(int[] item:items){
            int price=item[0];
            int beauty=item[1];
    
            int[] lastbracket=res.get(res.size() -1);

            if(beauty > lastbracket[1]){
                lastbracket[2] = price;
                res.add(new int[] {price,beauty,maxbeauty});
                // res will contain cumulative price-beauty brackets,
                //allowing us to check the maximum beauty for any budget by examining the highest bracket we can afford.
            }
        }
        int[] ans=new int[queries.length];
        int k=0;
        for(int query:queries){
            for(int i=res.size()-1;i>=0;i--){
                if(res.get(i)[0]<=query){
                    ans[k++]=res.get(i)[1];
                    break;
                }
            }
        }
        
        return ans;
    }
}
