internal class HitCounter {
  private val counter: Map<Int, Int>

  /** Initialize your data structure here.  */
  init {
    counter = HashMap()
  }

  /**
   * Record a hit.
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  fun hit(timestamp: Int) {
    counter.put(timestamp, (counter[timestamp] ?: 0) + 1)
  }

  /**
   * Return the number of hits in the past 5 minutes.
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  fun getHits(timestamp: Int): Int {
    var hits = 0
    for (entry in counter.entrySet()) {
      if (entry.getKey() + 300 > timestamp) {
        hits += entry.getValue()
      }
    }
    return hits
  }
}
