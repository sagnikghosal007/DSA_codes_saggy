class Solution {
    public String shortestSuperstring(String[] words) {
        Map<String,String> map=new HashMap<>();
        int unusedWord=0;
        for(int i=0;i<words.length;i++){
            unusedWord |=1<<i; //marking the unused word
        }
        //calling recursiive function to find the shoirtet string
        return shortestSuperstring(words,"",unusedWord,map);
    }
    private String shortestSuperstring(String[] words, String startWord, int unused, Map<String,String> map){
        if(unused==0){
            return startWord;
        }
        String key= startWord + "|" + unused;
         // if it conatains the key or not
         if(map.containsKey(key)){
            return map.get(key);
         }
         String shortest=null;
         for(int i=0;i<words.length;i++){
            if(!isconsumed(unused,i)){
                    String superstring=shortestSuperstring(words,words[i],consume(unused,i),map);
                    String appended=overlapAppend(startWord,superstring);
                    if(shortest==null || appended.length()<shortest.length()){
                        shortest=appended;
                    }
                }
            }
            map.put(key,shortest);
            return shortest;
         }
         private String overlapAppend(String a, String b){
            for(int i=Math.max(1,a.length()-b.length());i<a.length();i++)
            {
                boolean match=true;
                for(int j=i;j<a.length();j++){
                    if(a.charAt(j)!=b.charAt(j-i)){
                        match=false;
                        break;
                    }
                }
                if(match){
                    return a.substring(0,i)+b;
                }
            }
            return a+b;
         }
         private boolean isconsumed(int unused,int i){
            return ((unused>>i)&1)==0;
         }
         private int consume(int unused,int i){
            return unused & ~(1<<i);
         }
    }
