/* saqmple i/o:
Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
*/

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


/*  
Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.
  */
