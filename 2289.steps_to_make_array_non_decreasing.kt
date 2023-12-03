import kotlin.math.max

class Solution {
  fun totalSteps(nums: IntArray): Int {
    val stk: Deque<Int> = ArrayDeque()
    var ans = 0
    val n = nums.size
    val dp = IntArray(n)
    for (i in n - 1 downTo 0) {
      while (!stk.isEmpty() && nums[i] > nums[stk.peek()]) {
        dp[i] = max((dp[i] + 1).toDouble(), dp[stk.pop()].toDouble()).toInt()
        ans = max(ans.toDouble(), dp[i].toDouble()).toInt()
      }
      stk.push(i)
    }
    return ans
  }
}
