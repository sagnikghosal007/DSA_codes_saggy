/*
We say s1[i] and s2[i] are equivalent characters.

For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
Equivalent characters follow the usual rules of any equivalence relation:

Reflexivity: 'a' == 'a'.
Symmetry: 'a' == 'b' implies 'b' == 'a'.
Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.


Hint 1
Model these equalities as edges of a graph.
Hint 2
Group each connected component of the graph and assign each node of this component to the node with the lowest lexicographically character.
Hint 3
Finally convert the string with the precalculated information.

*/

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int m=baseStr.length();
        int n=s1.length();
        ArrayList<ArrayList<Character>> adj = new ArrayList<>();

       for (int i = 0; i < 26; i++) {
    adj.add(new ArrayList<>());
}
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            char u=s1.charAt(i);
            char v=s2.charAt(i);
           adj.get(u - 'a').add(v);
           adj.get(v - 'a').add(u);
        }
        for(char ch:baseStr.toCharArray()){
            int[] vis=new int[26];

            char minChar=dfsMinChar(adj,ch,vis);
            ans.append(minChar);
        }
        return ans.toString();
    }
    private char dfsMinChar( ArrayList<ArrayList<Character>> adj,char ch,int[] vis){
        vis[ch-'a']=1;//mark as visited
        char minChar=ch;
        // we need to check unvisited and lexicographically smaller than ch 
        for (char neighbor : adj.get(ch - 'a')) {
            if (vis[neighbor - 'a']==0) {
                char res = dfsMinChar(adj,neighbor, vis);
                if (res < minChar) {
                    minChar = res;
                }
            }
        }
        return minChar;
    }
}
