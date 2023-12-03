class Solution {
  fun seePeople(heights: Array<IntArray>): Array<IntArray> {
    val m = heights.size
    val n = heights[0].size
    val ans = Array(m) { IntArray(0) }
    for (i in 0 until m) {
      ans[i] = f(heights[i])
    }
    for (j in 0 until n) {
      val nums = IntArray(m)
      for (i in 0 until m) {
        nums[i] = heights[i][j]
      }
      val add = f(nums)
      for (i in 0 until m) {
        ans[i][j] += add[i]
      }
    }
    return ans
  }

  private fun f(nums: IntArray): IntArray {
    val n = nums.size
    val ans = IntArray(n)
    val stk: Deque<Int> = ArrayDeque()
    for (i in n - 1 downTo 0) {
      while (!stk.isEmpty() && stk.peek() < nums[i]) {
        stk.pop()
        ++ans[i]
      }
      if (!stk.isEmpty()) {
        ++ans[i]
      }
      while (!stk.isEmpty() && stk.peek() === nums[i]) {
        stk.pop()
      }
      stk.push(nums[i])
    }
    return ans
  }
}
