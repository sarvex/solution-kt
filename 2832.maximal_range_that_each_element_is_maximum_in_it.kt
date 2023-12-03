class Solution {
  fun maximumLengthOfRanges(nums: IntArray): IntArray {
    val n = nums.size
    val left = IntArray(n)
    val right = IntArray(n)
    Arrays.fill(left, -1)
    Arrays.fill(right, n)
    val stk: Deque<Int> = ArrayDeque()
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
      while (!stk.isEmpty() && nums[stk.peek()] <= nums[i]) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        right[i] = stk.peek()
      }
      stk.push(i)
    }
    val ans = IntArray(n)
    for (i in 0 until n) {
      ans[i] = right[i] - left[i] - 1
    }
    return ans
  }
}
