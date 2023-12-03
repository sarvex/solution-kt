import kotlin.math.min

class Solution {
  fun minimumDeviation(nums: IntArray): Int {
    val q: PriorityQueue<Int> = PriorityQueue { a, b -> b - a }
    var mi = Int.MAX_VALUE
    for (v in nums) {
      if (v % 2 == 1) {
        v = v shl 1
      }
      q.offer(v)
      mi = min(mi.toDouble(), v.toDouble()).toInt()
    }
    var ans: Int = q.peek() - mi
    while (q.peek() % 2 === 0) {
      val x: Int = q.poll() / 2
      q.offer(x)
      mi = min(mi.toDouble(), x.toDouble()).toInt()
      ans = Math.min(ans, q.peek() - mi)
    }
    return ans
  }
}
