class Solution {
  fun halveArray(nums: IntArray): Int {
    var s = 0.0
    val q: PriorityQueue<Double> = PriorityQueue(Collections.reverseOrder())
    for (v in nums) {
      q.offer(v * 1.0)
      s += v.toDouble()
    }
    s /= 2.0
    var ans = 0
    while (s > 0) {
      val t: Double = q.poll()
      s -= t / 2.0
      q.offer(t / 2.0)
      ++ans
    }
    return ans
  }
}
