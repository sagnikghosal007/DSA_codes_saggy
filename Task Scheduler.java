class Task implements Comparable<Task>{
    int frequency;
    int executionTime;
    Task(int f, int e){
        frequency=f;
        executionTime=e;
    }
    public int compareTo(Task that){
        return that.frequency-this.frequency;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> mp=new HashMap<>();
        for(char ch: tasks){
            mp.put(ch, mp.getOrDefault(ch,0)+1);
        }
        // pq is sorted according to the decreasing order of freq tasks

        PriorityQueue<Task> pq=new PriorityQueue<>();
        //inserting task in pq
        for(Character ch: mp.keySet()){
            int freq=mp.get(ch);
            pq.offer(new Task(freq,0));
        }
        Queue<Task> q=new LinkedList<>();
        int time=0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            // check if there is a task in pq and process it 
            if(!pq.isEmpty()){
                Task task=pq.poll();
                task.frequency--;
                if(task.frequency>0){
                    task.executionTime=time+n;
                    q.offer(task);
                }
            }
            //shift the actual process into the 
            //still there to execute 
            while(!q.isEmpty() && q.peek().executionTime==time){
                pq.offer(q.poll());
            }
        }

        return time;
    }
}


//using freq array taking O(n^2logn) time complexity
// class Solution {
//     public int leastInterval(char[] tasks, int n) {
//        int[] freq = new int[26];
//         for (char task : tasks) {
//             freq[task - 'A']++;
//         }
//         Arrays.sort(freq);
//         int chunk = freq[25] - 1;
//         int idle = chunk * n;

//         for (int i = 24; i >= 0; i--) {
//             idle -= Math.min(chunk, freq[i]);
//         }

//         return idle < 0 ? tasks.length : tasks.length + idle; 
//     }
// }
