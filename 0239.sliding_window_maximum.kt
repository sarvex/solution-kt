import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val n = nums.size
    val ans = IntArray(n - k + 1)
    val q: Deque<Int> = ArrayDeque()
    var i = 0
    var j = 0
    while (i < n) {
      if (!q.isEmpty() && i - k + 1 > q.peekFirst()) {
        q.pollFirst()
      }
      while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
        q.pollLast()
      }
      q.offer(i)
      if (i >= k - 1) {
        ans[j++] = nums[q.peekFirst()]
      }
      ++i
    }
    return ans
  }
}
