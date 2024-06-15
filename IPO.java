
 class Solution {
    static class pair {
        int capital;
        int profit;

        pair(int c, int p) {
            this.capital = c;
            this.profit = p;
        }

    }
    public int findMaximizedCapital(int k, int w, int[] profit, int[] capital) {
         PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.capital - b.capital);
        PriorityQueue<pair> maxprofir = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        for (int i = 0; i < capital.length; i++) {
            pair p = new pair(capital[i], profit[i]);
            pq.add(p);
        }
        int tempw = 0;
        while (k > 0) {
            while (tempw <= w) {
                if (!pq.isEmpty() && pq.peek().capital == tempw) {

                    maxprofir.add(pq.poll());

                } else {
                    tempw++;
                }

            }
              if(maxprofir.isEmpty()){return w;}
            w += maxprofir.poll().profit;
            k--;

        }return w;
    }
}
