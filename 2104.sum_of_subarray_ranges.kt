internal class Solution {
  fun subArrayRanges(nums: IntArray): Long {
    val mx = f(nums)
    for (i in nums.indices) {
      nums[i] *= -1
    }
    val mi = f(nums)
    return mx + mi
  }

  private fun f(nums: IntArray): Long {
    val stk: Deque<Int> = ArrayDeque()
    val n = nums.size
    val left = IntArray(n)
    val right = IntArray(n)
    Arrays.fill(left, -1)
    Arrays.fill(right, n)
    for (i in 0 until n) {
      while (!stk.isEmpty() && nums[stk.peek()] <= nums[i]) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        left[i] = stk.peek()
      }
      stk.push(i)
    }
    stk.clear()
    for (i in n - 1 downTo 0) {
      while (!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        right[i] = stk.peek()
      }
      stk.push(i)
    }
    var s: Long = 0
    for (i in 0 until n) {
      s += (i - left[i]).toLong() * (right[i] - i) * nums[i]
    }
    return s
  }
}
