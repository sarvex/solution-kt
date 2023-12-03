import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
  fun maxResult(nums: IntArray, k: Int): Int {
    val n = nums.size
    val f = IntArray(n)
    val q: Deque<Int> = ArrayDeque()
    q.offer(0)
    for (i in 0 until n) {
      if (i - q.peekFirst() > k) {
        q.pollFirst()
      }
      f[i] = nums[i] + f[q.peekFirst()]
      while (!q.isEmpty() && f[q.peekLast()] <= f[i]) {
        q.pollLast()
      }
      q.offerLast(i)
    }
    return f[n - 1]
  }
}
