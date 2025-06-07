
class Solution {
    static class Pair {
        char ch;
        int idx;
        Pair(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }

    // static class Comp implements Comparator<Pair> {
    //     public int compare(Pair a, Pair b) {
    //         if (a.ch == b.ch) {
    //             return Integer.compare(a.idx, b.idx); // smaller index first
    //         }
    //         return Character.compare(a.ch, b.ch); // lexicographically smaller first
    //     }
    // }

    public String clearStars(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        // one-line compaartor implementation if same smallest character then inserted with largest index at front else we will insert the smallest character
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return(a.ch==b.ch)? b.idx-a.idx:Character.compare(a.ch,b.ch);
        });

        for (int i = 0; i < n; i++) {
            if (arr[i] == '*') {
                if (!pq.isEmpty()) {
                    int idx = pq.peek().idx;
                    pq.poll();
                    arr[idx] = '*'; // mark removed
                }
            } else {
                pq.offer(new Pair(arr[i], i));
            }
        }

        // Reconstruct the result string, skipping '*'
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (arr[i] != '*') {
                result.append(arr[i]);
            }
        }

        return result.toString();
    }
}
}

class Solution {
    public String clearStars(String s) {
        char[] str = s.toCharArray();
        Queue<P> pq = new PriorityQueue<>((a, b) -> {
           if (a.c == b.c) {
               return b.i - a.i;
           }
            return Character.compare(a.c, b.c);
        });
        
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (c != '*') {
                pq.add(new P(c, i));
                continue;
            }
            
            if (!pq.isEmpty()) {
                P p = pq.poll();
                str[p.i] = '*';
            }
        }
        char[] result = new char[str.length]; 
        int index = 0;
        for (char c : str) {
            if (c != '*') {
                result[index++] = c;
            }
        }
        return new String(result, 0, index); 
    }
}
