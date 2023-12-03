class Solution {
  fun makePrefSumNonNegative(nums: IntArray): Int {
    val pq: PriorityQueue<Int> = PriorityQueue()
    var ans = 0
    var s: Long = 0
    for (x in nums) {
      s += x.toLong()
      if (x < 0) {
        pq.offer(x)
      }
      while (s < 0) {
        s -= pq.poll()
        ++ans
      }
    }
    return ans
  }
}
