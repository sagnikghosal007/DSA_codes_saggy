class Solution {
    public List<String> commonChars(String[] words) {
        int ans[]=count(words[0]);
        for(int i=1;i<words.length;i++){
            ans=intersection(ans,count(words[i]));
        }
        List<String> arr=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(ans[i]!=0)
            {
                char a=(char)('a'+i);
                String s=String.valueOf(a);
                while(ans[i]>0){
                    arr.add(s);
                    ans[i]--;
                }
            }
        }
        return arr;
    }
    private int[] intersection(int[] a, int[] b){
        int[] t=new int[26];
        for(int i=0;i<26;i++){
            t[i]=Math.min(a[i],b[i]);
        }
        return t;
    }
    private int[] count(String str){
        int[] t=new int[26];
        for(char c:str.toCharArray()){
            t[c-'a']++;
        }
        return t;
    }
}



//alternative approach using java 8 features
    // public List<String> commonChars(String[] A) {
    //     int[] count = new int[26]; 
    //     Arrays.fill(count, Integer.MAX_VALUE);
    //     for (String str : A) {
    //         int[] cnt = new int[26];
    //         str.chars().forEach(c -> ++cnt[c - 'a']); // count each char's frequency in string str.
    //         IntStream.range(0, 26).forEach(i ->  count[i] = Math.min(cnt[i], count[i])); // update minimum frequency.
    //     }
    //     List<String> ans = new ArrayList<>();
    //     IntStream.range('a', 'z' + 1).forEach(c ->  ans.addAll(Collections.nCopies(count[c - 'a'], "" + (char)c)));
    //     return ans;
    // }
