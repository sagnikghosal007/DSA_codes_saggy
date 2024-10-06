class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Set<Integer> sus=new HashSet<>();
        sus.add(k);
        boolean isChange=true;
        while(isChange){
            isChange=false;
            for(int[] invoke:invocations){
                int u=invoke[0],v=invoke[1];
                if(sus.contains(u) && !sus.contains(v)){
                    sus.add(v);
                    isChange=true;
                }
            }
        }
        for(int[] invoke:invocations){
            int u=invoke[0],v=invoke[1];
                if(!sus.contains(u) && sus.contains(v)){
                    return Arrays.asList(createArray(n));
                }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!sus.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }

    private static Integer[] createArray(int n) {
        Integer[] result = new Integer[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        return result;
    }
}
