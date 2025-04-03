//brute force method in java 
// class Solution {
//     public String reverseParentheses(String s) {
//         StringBuilder sb = new StringBuilder();
//         Stack<Integer> st = new Stack<>();

//         for (char ch : s.toCharArray()) {
//             if (ch == '(') {
//                 st.push(sb.length());
//             } else if (ch == ')') {
//                 int l = st.pop(); 
//                 String reversed = new StringBuilder(sb.substring(l)).reverse().toString();
//                 sb.replace(l, sb.length(), reversed);
//             } else {
//                 sb.append(ch);
//             }
//         }
//         return sb.toString();
//     }
// }
// alternate method in java 
// class Solution {
//     public String reverseParentheses(String s) {
//         Stack<String> st = new Stack<>();
//         StringBuilder sb = new StringBuilder();

//         for (char ch : s.toCharArray()) {
//            if(ch=='('){
//                 st.push(sb.toString());
//                 sb.setLength(0);
//            }
//            else if(ch==')'){
//             sb.reverse();
//             sb.insert(0,st.pop());
//            }
//            else{
//             sb.append(ch);
//            }
//         }
//         return sb.toString();
//     }
// }
// best method and most optimal based on observations
// thyis method is called WarmHole Teleportation


class Solution{
    public String reverseParentheses(String s){
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        int[] door=new int[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }
            else if(s.charAt(i)==')'){
                int j=st.peek();
                st.pop();
                door[i]=j;
                door[j]=i;
            }
        }
        StringBuilder sb =new StringBuilder();
        int flag=1;
        for(int i=0;i<n;i+=flag){
            if(s.charAt(i)=='(' || s.charAt(i)==')'){
                i=door[i];
                flag=-flag;//by using the flag we are changing the direction
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }
}
