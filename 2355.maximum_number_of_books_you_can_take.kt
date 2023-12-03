import kotlin.math.max
import kotlin.math.min

class Solution {
  fun maximumBooks(books: IntArray): Long {
    val n = books.size
    val nums = IntArray(n)
    for (i in 0 until n) {
      nums[i] = books[i] - i
    }
    val left = IntArray(n)
    Arrays.fill(left, -1)
    val stk: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        left[i] = stk.peek()
      }
      stk.push(i)
    }
    var ans: Long = 0
    val dp = LongArray(n)
    dp[0] = books[0].toLong()
    for (i in 0 until n) {
      val j = left[i]
      val v = books[i]
      val cnt = min(v.toDouble(), (i - j).toDouble()).toInt()
      val u = v - cnt + 1
      val s = (u + v).toLong() * cnt / 2
      dp[i] = s + if (j == -1) 0 else dp[j]
      ans = max(ans.toDouble(), dp[i].toDouble()).toLong()
    }
    return ans
  }
}
