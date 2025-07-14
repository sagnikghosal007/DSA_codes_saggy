class Solution {
    class meet{
        int start;
        int end;
        int pos;
        public meet(int start , int end, int pos){
            this.start=start;
            this.end=end;
            this.pos;
        }
    }
    class meetingComparator implements Comparator<meet>{
        @Override
        public int compare(meet o1,meet o2){
            if(o1.end<o2.end){
                return -1;
            }
            else if(o1.end>o2.end){
                return 1;
            }
            else if(o1.pos<o2.pos){
                return -1;
            }
            return 1;
        }
    }
    public int maxMeetings(int[] start, int[] end) {
       //your code goes here
       int n=start.length;
       ArrayList<meet> m=new ArrayList<>();
       for(int i=0;i<n;i++){
        m.add(new meet(start[i],end[i],i+1));
       }
       meetingComparator mc=new meetingComparator<>();
       Collections.sort(m,mc);
       ArrayList<Integer> ans=new ArrayList<>();
       ans.add(m.get(0).pos);
       int limit=m.get(0).end;
       for(int i=1;i<n;i++){
            if(m.get(i).start>limit){
                limit=m.get(i).end;
                ans.add(m.get(i).pos);
            }
       }
       return ans.size();
    }
}
