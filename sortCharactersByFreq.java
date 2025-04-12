//sort characters by frequency 
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(char ch:s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        // PrirityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>(
        //     (a,b)->b.getValue() - a.getValue()
        // );
        StringBuilder ans=new StringBuilder();
        List<Character> list=new ArrayList<>(mp.keySet());
        list.sort((a,b)->mp.get(b)-mp.get(a));// cusstorm sorting into descending order by their values
        for(char ch:list){
            for(int i=0;i<mp.get(ch);i++){
                ans.append(ch);
            }
        }
        return ans.toString();

    }
}

//hashmap approach 


class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        
        pq.addAll(hm.entrySet());
        
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        
        return result.toString();
    }
}

