class Solution {
    public int maxScore(String s) {
        int oneC=0;
        int zeroC=0;
        int n=s.length();
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            if((s.charAt(i)-'0')==1) oneC++;
            else zeroC++;

            ans=Math.max(ans,zeroC-oneC);
        }
        if(s.charAt(n-1)-'0'==1) oneC++;

        return ans=ans+oneC;
    }
}

// class Solution {
//     public int maxScore(String s) {
//         int ones = 0;
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '1') {
//                 ones++;
//             }
//         }
//         int maxScore=Integer.MIN_VALUE;
//         int zeros=0;
//         for(int i=0;i<s.length()-1;i++){
//             if(s.charAt(i)=='1'){
//                 ones--;
//             }
//             else{
//                 zeros++;
//             }
//             int score = zeros+ones;
//             maxScore=Math.max(score,maxScore);

//         }
//         return maxScore;  
//     }
//     // public int zeroCount(String s){
//     //     int count=0;
//     //     for(char ch:s.toCharArray()){
//     //         if(ch=='0') count++;
//     //     }
//     //     return count;
//     // }
//     // public int oneCount(String s){
//     //     int count=0;
//     //     for(char ch:s.toCharArray()){
//     //         if(ch=='1') count++;
//     //     }
//     //     return count;
//     // }
// }
