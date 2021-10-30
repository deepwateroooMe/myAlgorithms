import com.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class Twitter {

    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        
    }
    
    public static void main(String[] args) {

        Twitter t = new Twitter();
        t.postTweet(1, 5); // User 1 posts a new tweet (id = 5).

        List<Integer> r = t.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        System.out.println("r.size(): " + r.size());
        for (int z = 0; z < r.size(); ++z) 
            System.out.print(r.get(z) + ", ");
        System.out.print("\n");

        t.follow(1, 2);    // User 1 follows user 2.
        t.postTweet(2, 6); // User 2 posts a new tweet (id = 6).

        List<Integer> r2 = t.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        System.out.println("r2.size(): " + r2.size());
        for (int z = 0; z < r2.size(); ++z) 
            System.out.print(r2.get(z) + ", ");
        System.out.print("\n");
        
        t.unfollow(1, 2);  // User 1 unfollows user 2.
        t.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    }
}
