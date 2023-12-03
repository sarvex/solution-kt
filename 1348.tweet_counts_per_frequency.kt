import kotlin.math.min

class TweetCounts {
  private val data: Map<String, TreeMap<Int, Int>> = HashMap()
  fun recordTweet(tweetName: String, time: Int) {
    data.putIfAbsent(tweetName, TreeMap())
    val tm: Unit = data[tweetName]
    tm.put(time, tm.getOrDefault(time, 0) + 1)
  }

  fun getTweetCountsPerFrequency(
    freq: String, tweetName: String, startTime: Int, endTime: Int
  ): List<Int> {
    var f = 60
    if ("hour" == freq) {
      f = 3600
    } else if ("day" == freq) {
      f = 86400
    }
    val tm: Unit = data[tweetName]
    val ans: List<Int> = ArrayList()
    var i = startTime
    while (i <= endTime) {
      var s = 0
      val end = min((i + f).toDouble(), (endTime + 1).toDouble()).toInt()
      for (v in tm.subMap(i, end).values()) {
        s += v
      }
      ans.add(s)
      i += f
    }
    return ans
  }
}
