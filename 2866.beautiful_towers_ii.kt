class Solution {
  fun maximumSumOfHeights(maxHeights: List<Int>): Long {
    val n: Int = maxHeights.size()
    val stk: Deque<Int> = ArrayDeque()
    val left = IntArray(n)
    val right = IntArray(n)
    Arrays.fill(left, -1)
    Arrays.fill(right, n)
    for (i in 0 until n) {
      val x = maxHeights[i]
      while (!stk.isEmpty() && maxHeights[stk.peek()] > x) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        left[i] = stk.peek()
      }
      stk.push(i)
    }
    stk.clear()
    for (i in n - 1 downTo 0) {
      val x = maxHeights[i]
      while (!stk.isEmpty() && maxHeights[stk.peek()] >= x) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        right[i] = stk.peek()
      }
      stk.push(i)
    }
    val f = LongArray(n)
    val g = LongArray(n)
    for (i in 0 until n) {
      val x = maxHeights[i]
      if (i > 0 && x >= maxHeights[i - 1]) {
        f[i] = f[i - 1] + x
      } else {
        val j = left[i]
        f[i] = 1L * x * (i - j) + if (j >= 0) f[j] else 0
      }
    }
    for (i in n - 1 downTo 0) {
      val x = maxHeights[i]
      if (i < n - 1 && x >= maxHeights[i + 1]) {
        g[i] = g[i + 1] + x
      } else {
        val j = right[i]
        g[i] = 1L * x * (j - i) + if (j < n) g[j] else 0
      }
    }
    var ans: Long = 0
    for (i in 0 until n) {
      ans = Math.max(ans, f[i] + g[i] - maxHeights[i])
    }
    return ans
  }
}
