import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.max

class Solution {
  fun constrainedSubsetSum(nums: IntArray, k: Int): Int {
    val n = nums.size
    val dp = IntArray(n)
    var ans = Int.MIN_VALUE
    val q: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      if (!q.isEmpty() && i - q.peek() > k) {
        q.poll()
      }
      dp[i] = (max(0.0, (if (q.isEmpty()) 0 else dp[q.peek()]).toDouble()) + nums[i]).toInt()
      while (!q.isEmpty() && dp[q.peekLast()] <= dp[i]) {
        q.pollLast()
      }
      q.offer(i)
      ans = max(ans.toDouble(), dp[i].toDouble()).toInt()
    }
    return ans
  }
}
