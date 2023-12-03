import kotlin.math.min

class Solution {
  fun minimumDifference(nums: IntArray): Long {
    val m = nums.size
    val n = m / 3
    var s: Long = 0
    val pre = LongArray(m + 1)
    var pq: PriorityQueue<Int?> = PriorityQueue { a, b -> b - a }
    for (i in 1..n * 2) {
      val x = nums[i - 1]
      s += x.toLong()
      pq.offer(x)
      if (pq.size() > n) {
        s -= pq.poll()
      }
      pre[i] = s
    }
    s = 0
    val suf = LongArray(m + 1)
    pq = PriorityQueue()
    for (i in m downTo n + 1) {
      val x = nums[i - 1]
      s += x.toLong()
      pq.offer(x)
      if (pq.size() > n) {
        s -= pq.poll()
      }
      suf[i] = s
    }
    var ans = 1L shl 60
    for (i in n..n * 2) {
      ans = min(ans.toDouble(), (pre[i] - suf[i + 1]).toDouble()).toLong()
    }
    return ans
  }
}
