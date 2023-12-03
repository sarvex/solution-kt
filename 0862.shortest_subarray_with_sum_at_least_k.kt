internal class Solution {
  fun shortestSubarray(nums: IntArray, k: Int): Int {
    val n = nums.size
    val s = LongArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
    val q: Deque<Int> = ArrayDeque()
    var ans = n + 1
    for (i in 0..n) {
      while (!q.isEmpty() && s[i] - s[q.peek()] >= k) {
        ans = Math.min(ans, i - q.poll())
      }
      while (!q.isEmpty() && s[q.peekLast()] >= s[i]) {
        q.pollLast()
      }
      q.offer(i)
    }
    return if (ans > n) -1 else ans
  }
}
