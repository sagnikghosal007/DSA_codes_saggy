class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n=timePoints.size();
        int ans=Integer.MAX_VALUE;
        int minutes[]=new int[n];
        for(int i=0;i<n;i++){
            String s=timePoints.get(i);
            int hour=Integer.parseInt(s.substring(0,2));
            int minute=Integer.parseInt(s.substring(3)); 
            minutes[i]=hour*60+minute;
        }
        Arrays.sort(minutes);
        for (int i = 0; i < minutes.length - 1; i++) {
            ans = Math.min(ans, minutes[i + 1] - minutes[i]);
        }

        // consider difference between last and first element
        return Math.min(ans,24 * 60 - minutes[minutes.length - 1] + minutes[0]);
    }
}
