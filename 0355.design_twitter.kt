internal class Twitter {
  private val userTweets: Map<Int, List<Int>>
  private val userFollowing: Map<Int, Set<Int>>
  private val tweets: Map<Int, Int>
  private var time: Int

  /** Initialize your data structure here.  */
  init {
    userTweets = HashMap()
    userFollowing = HashMap()
    tweets = HashMap()
    time = 0
  }

  /** Compose a new tweet.  */
  fun postTweet(userId: Int, tweetId: Int) {
    userTweets.computeIfAbsent(userId) { k -> ArrayList() }.add(tweetId)
    tweets.put(tweetId, ++time)
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed
   * must be posted by users who the user followed or by the user herself. Tweets must be ordered
   * from most recent to least recent.
   */
  fun getNewsFeed(userId: Int): List<Int> {
    val following = userFollowing[userId] ?: HashSet()
    val users: Set<Int> = HashSet(following)
    users.add(userId)
    val pq: PriorityQueue<Int> = PriorityQueue(10) { a, b -> tweets[b]!! - tweets[a]!! }
    for (u in users) {
      val userTweet = userTweets[u]
      if (userTweet != null && !userTweet.isEmpty()) {
        var i: Int = userTweet.size() - 1
        var k = 10
        while (i >= 0 && k > 0) {
          pq.offer(userTweet[i])
          --i
          --k
        }
      }
    }
    val res: List<Int> = ArrayList()
    while (!pq.isEmpty() && res.size() < 10) {
      res.add(pq.poll())
    }
    return res
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op.  */
  fun follow(followerId: Int, followeeId: Int) {
    userFollowing.computeIfAbsent(followerId) { k -> HashSet() }.add(followeeId)
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op.  */
  fun unfollow(followerId: Int, followeeId: Int) {
    userFollowing.computeIfAbsent(followerId) { k -> HashSet() }.remove(followeeId)
  }
}
