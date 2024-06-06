//In the ongoing PRIDE month leetcode decides to solve the problem named HANDS OF STRAIGHT , ironical right??
//just kidding!
//This very problem is very similar to the dividing the array into k consecutive integers problem
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
       int n=hand.length;
       Map<Integer,Integer> mp=new TreeMap<>();
       if(n%groupSize!=0) return false;

       for(int h:hand){
        mp.put(h,mp.getOrDefault(h,0)+1);
       }

       //iterating over the map
       for(int key:mp.keySet()){
        if(mp.get(key)>0){
            for(int i=1;i<groupSize;i++){
                if(mp.getOrDefault(key+i,0)<mp.get(key)){
                    return false;
                }
                mp.put(key+i,mp.get(key+i)-mp.get(key));
            }
        }
       }
       return true;
    }
}
// it took 180ms time , but dont worry I got covered wiht an altrernate solution.
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        int ks = n / groupSize;
        int[] klen = new int[ks];
        int[] kmax = new int[ks];
        for (int i = 0; i < ks; i++) {
            kmax[i] = -1;
        }
        int top = 0;
        int i = 0;
        while (i < hand.length) {
            int j = top;
            int prev = hand[i];
            while (j < ks && prev == hand[i]) {
                if (kmax[j] != -1 && kmax[j] != hand[i] - 1) {
                    return false;
                }
                kmax[j] = hand[i];
                klen[j]++;
                prev = hand[i];
                if (top == j && klen[j] == groupSize) {
                    top = top + 1;
                }
                i = i + 1;
                j = j + 1;
            }
        }
        return top == ks;
    }
  

