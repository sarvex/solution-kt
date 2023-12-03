class Solution {
  fun maxWidthRamp(nums: IntArray): Int {
    val n = nums.size
    val stk: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      if (stk.isEmpty() || nums[stk.peek()] > nums[i]) {
        stk.push(i)
      }
    }
    var ans = 0
    for (i in n - 1 downTo 0) {
      while (!stk.isEmpty() && nums[stk.peek()] <= nums[i]) {
        ans = Math.max(ans, i - stk.pop())
      }
      if (stk.isEmpty()) {
        break
      }
    }
    return ans
  }
}
