With using stack:
TC: O(n) & SC: O(n)
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        int c=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(ch);
            }
            else{
                if(st.isEmpty())
                c++;
                else
                st.pop();    
            }
        }
        return c + st.size();
    }
}

Without using stack:
TC: O(n) & SC: O(1)

class Solution {
    public int minAddToMakeValid(String s) {
           int size=0;
           int open=0;
           for(char ch:s.toCharArray()){
               if(ch=='('){
                   size++;
               }
               else if(size>0){
                   size--;
               }
               else{
                   open++;
               }
           }
           return size+open;
    }
}
