import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DesignTwitter {
}

class Twitter {
    private class Twiterr   {
        public int tweetCount;
        public Set<Integer> following = new HashSet<>();
        public Twiterr()    {
            this.tweetCount = 0;
        }

    }
    private Map<Integer, Twiterr> users;
    private Map<Integer, Integer> map;
    private ArrayDeque<Integer> allTweets;
    public Twitter() {
        users = new HashMap<>();
        map = new HashMap<>();
        allTweets = new ArrayDeque<>();
    }

    public void postTweet(int userId, int tweetId) {
        users.putIfAbsent(userId, new Twiterr());
        users.get(userId).tweetCount++;
        allTweets.addFirst(tweetId);
        map.put(tweetId, userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId) || (users.get(userId).tweetCount == 0 && users.get(userId).following.size() == 0))
            return new ArrayList<>();

        Set<Integer> following = new HashSet<>();
        List<Integer> tweets = new ArrayList<>();
        if (users.containsKey(userId))  {
            following = users.get(userId).following;
        }
        int i = 0;
        var clone = allTweets.clone();
        var currentTweet = clone.pollFirst();
        while (i < 10)  {
            if (currentTweet!= null && (map.get(currentTweet) == userId || following.contains(map.get(currentTweet))))   {
                tweets.add(currentTweet);
                i++;
            }
            currentTweet = clone.pollFirst();
            if (clone.size() == 0)
                break;
        }
        if (i < 10 && currentTweet!= null && (map.get(currentTweet) == userId || following.contains(map.get(currentTweet)))) {
            tweets.add(currentTweet);
        }
        return tweets;
    }

    public void follow(int followerId, int followeeId) {
        users.putIfAbsent(followerId, new Twiterr());
        users.putIfAbsent(followeeId, new Twiterr());
        users.get(followerId).following.add(followeeId);
    }
    public void unfollow(int followerId, int followeeId) {
        users.putIfAbsent(followerId, new Twiterr());
        users.putIfAbsent(followeeId, new Twiterr());
        users.get(followerId).following.remove(followeeId);
    }
}


/* Best runtime : 7ms :
class Twitter {

        final List<int[]> tweets;
        final Map<Integer, Set<Integer>> followMap;

        public Twitter() {
            tweets = new ArrayList<>();
            followMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            tweets.add(new int[]{userId, tweetId});
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = followMap.getOrDefault(userId, new HashSet<>());
            int i = tweets.size() - 1;
            while (i >= 0 && list.size() < 10) {
                int[] tweet = tweets.get(i);
                if (tweet[0] == userId || set.contains(tweet[0])) {
                    list.add(tweet[1]);
                }
                i--;
            }
            return list;
        }

        public void follow(int followerId, int followeeId) {
            Set<Integer> set = followMap.getOrDefault(followerId, new HashSet<>());
            set.add(followeeId);
            followMap.put(followerId, set);
        }

        public void unfollow(int followerId, int followeeId) {
            Set<Integer> set = followMap.getOrDefault(followerId, new HashSet<>());
            set.remove(followeeId);
            followMap.put(followerId, set);
        }
    }

 */

/*

class Twitter {

    private class Twiterr   {
        public ArrayDeque<Integer> tweets = new ArrayDeque<>();
        public Set<Integer> following = new HashSet<>();
//        public Set<Integer> followers = new HashSet<>();

        public void postTweet(int tweetId)  {
            tweets.addFirst(tweetId);
        }
//        public List<Integer> getTweets()    {
//            List<Integer> list = new ArrayList<>();
//            var clone = tweets.clone();
//            int i=0;
//            while(i<10 && clone.size()>0) {
//                list.add(clone.poll());
//                i++;
//            }
//            return list;
//        }
//        public void removeTweets(ArrayDeque<Integer> removeTweet)   {
//            ArrayDeque<Integer> newTweets = new ArrayDeque<>();
//            var tempTweet = tweets.clone();
//
//            var rmTweet = removeTweet.pollFirst();
//            var currentTweet = tempTweet.pollFirst();
//            while (removeTweet.size() >= 0)  {
//                if (rmTweet == currentTweet && removeTweet.size() == 0)    {
//                    currentTweet = tempTweet.pollFirst();
//                    newTweets.addLast(currentTweet);
//                }
//                else if (rmTweet == currentTweet)    {
//                    rmTweet = removeTweet.pollFirst();
//                    currentTweet = tempTweet.pollFirst();
//                }   else {
//                    newTweets.add(currentTweet);
//                    currentTweet = tempTweet.pollFirst();
//                }
//                if (removeTweet.size() == 0)    {
//                    break;
//                }
//            }
//            while (tempTweet.size() > 0)    {
//                newTweets.addLast(tempTweet.pollFirst());
//            }
//            this.tweets = newTweets;
//        }
    }
    private Map<Integer, Twiterr> users;
    private Map<Integer, Integer> map;
    private ArrayDeque<Integer> allTweets;
    public Twitter() {
        users = new HashMap<>();
        map = new HashMap<>();
        allTweets = new ArrayDeque<>();
    }

    public void postTweet(int userId, int tweetId) {
        users.putIfAbsent(userId, new Twiterr());
        allTweets.addFirst(tweetId);
        map.put(tweetId, userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> following = new HashSet<>();
        List<Integer> tweets = new ArrayList<>();
        if (users.containsKey(userId))  {
            following = users.get(userId).following;
        }
        int i = 0;
        var clone = allTweets.clone();
        var currentTweet = clone.pollFirst();
        while (i < 10)  {
            if (map.get(currentTweet) == userId || following.contains(map.get(currentTweet)))   {
                tweets.add(currentTweet);
                i++;
            }
            currentTweet = clone.pollFirst();
            if (clone.size() == 0)
                break;
        }
        if (currentTweet!= null && (map.get(currentTweet) == userId || following.contains(map.get(currentTweet)))) {
            tweets.add(currentTweet);
        }
        return tweets;
    }

    public void follow(int followerId, int followeeId) {
        users.putIfAbsent(followerId, new Twiterr());
        users.putIfAbsent(followeeId, new Twiterr());
        users.get(followerId).following.add(followeeId);
//        users.get(followeeId).followers.add(followerId);
    }
    public void unfollow(int followerId, int followeeId) {
        users.putIfAbsent(followerId, new Twiterr());
        users.putIfAbsent(followeeId, new Twiterr());
        users.get(followerId).following.remove(followeeId);
//        user.removeTweets(users.get(followeeId).tweets);
    }
}
 */