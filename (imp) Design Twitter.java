class Tweet implements Comparable<Tweet>{
    int time;
    int tweetId;
    Tweet(int t, int id){
        time =t;
        tweetId=id;
    }

    public int compareTo(Tweet that){
        //decreasing order
        return that.time-this.time;
    }
}

class User{
    int userId;
    HashSet<Integer> followers;
    List<Tweet> tweets;
    User(int userId){
        this.userId=userId;
        followers=new HashSet<>();
        tweets=new LinkedList<>();
    }
    public void addTweet(Tweet t){
        tweets.add(0,t); // insertion at the head of th linked list
    }

    public void addFollower(int followeeId){
        followers.add(followeeId);
    }
     public void removeFollower(int followeeId){
        followers.remove(followeeId);
    }
}

class Twitter {

    HashMap<Integer,User> userMap;
    int timeStamp;


    public Twitter() {
        userMap=new HashMap<>();
        timeStamp=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timeStamp++;
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        User user=userMap.get(userId);
        user.addTweet(new Tweet(timeStamp,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId)){
            return new ArrayList<>();
        }

        PriorityQueue<Tweet> pq=new PriorityQueue<>();

        //my task is add self tweet + followers tweets 
        User user=userMap.get(userId);
        for(int followerId: user.followers){ // adding the followers tweets
            int count=0;
            for(Tweet tweet:userMap.get(followerId).tweets){
                pq.offer(tweet);
                count++;
                if(count>10){ // optimsed kore dilam
                    break;
                }
            }
        }
        //self tweets adding to pq case
        int count=0;
        for(Tweet tweet:user.tweets){
                pq.offer(tweet);
                count++;
                if(count>10){ // optimsed kore dilam
                    break;
            }
        }

        List<Integer> ans=new ArrayList<>();
        int index=0;
        while(!pq.isEmpty() && index<10){
            Tweet tweet=pq.poll();
            ans.add(tweet.tweetId);
            index++;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
         if(!userMap.containsKey(followerId)){
            userMap.put(followerId,new User(followerId));
        }
         if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId,new User(followeeId));
        }
        User user=userMap.get(followerId);
        user.addFollower(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)){
            return;
        }
        User user=userMap.get(followerId);
        user.removeFollower(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
