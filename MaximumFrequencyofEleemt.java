class Solution {
    class Event{
        int x;
        int sign;
        Event(int x , int sign){
            this.x=x;
            this.sign=sign;
        }
    }
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n=nums.length;
        List<Event> events=new ArrayList<>();
        Set<Integer> criticalPoints=new HashSet<>();
        Map<Integer,Integer> freqMap=new HashMap<>();
        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
            int s=num-k;
            int e=num+k;

            events.add(new Event(s,+1));
            events.add(new Event(e+1,-1));

            criticalPoints.add(s);
            criticalPoints.add(e+1);
            criticalPoints.add(num);
        }
        events.sort(Comparator.comparingInt(e->e.x));

        List<Integer> sortedPoints=new ArrayList<>(criticalPoints);
        Collections.sort(sortedPoints);


        int maxFreqPossible=1,eventId=0,overlappingCount=0;
        for(int x: sortedPoints){
            while(eventId<events.size() && events.get(eventId).x<=x){
                overlappingCount+=(events.get(eventId).sign==1)?1:-1;
                eventId++;
            }
            int currPointFreq=freqMap.getOrDefault(x,0);
            int currPossibleFreq=currPointFreq+ Math.min(numOperations,Math.max(0,overlappingCount-currPointFreq));
            maxFreqPossible=Math.max(maxFreqPossible,currPossibleFreq);
        }
        return maxFreqPossible;
    }
}
