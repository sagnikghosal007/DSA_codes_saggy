//Flipkart
class Solution {
    public int firstUniqChar(String s) {
//Creating a frequency array
        int freq[] = new int[26];
//creating a queue of characters
        Queue<Character> q = new LinkedList<>();
//Itterate over each charactre in string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
//add each element to the queue
            q.add(ch);
//increase the freq of that element in the array
            freq[ch - 'a']++;
//while queue is empty and if the freq of character is the 1st character in the queue is greater than 1 then just remove it
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
        }
//run a loop and check if the character of string has freq equal to 1 then retuen it
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
//if array is empty then return -1
        return -1;
    }
}



//Normal HashMap Approach 

// class Solution {
//     public int firstUniqChar(String s) {
//         int n=s.length();
//         char[] chars=s.toCharArray();
//         HashMap<Character,Integer> mp=new HashMap<>();
//         for(char ch:chars){
//             mp.put(ch,mp.getOrDefault(ch,0)+1);
//         }
//         for(int i=0;i<n;i++){
//             if(mp.get(s.charAt(i))==1){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }
