class Solution {
  fun validSubarraySize(nums: IntArray, threshold: Int): Int {
    val n = nums.size
    val left = IntArray(n)
    val right = IntArray(n)
    Arrays.fill(left, -1)
    Arrays.fill(right, n)
    val stk: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      val v = nums[i]
      while (!stk.isEmpty() && nums[stk.peek()] >= v) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        left[i] = stk.peek()
      }
      stk.push(i)
    }
    stk.clear()
    for (i in n - 1 downTo 0) {
      val v = nums[i]
      while (!stk.isEmpty() && nums[stk.peek()] >= v) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        right[i] = stk.peek()
      }
      stk.push(i)
    }
    for (i in 0 until n) {
      val v = nums[i]
      val k = right[i] - left[i] - 1
      if (v > threshold / k) {
        return k
      }
    }
    return -1
  }
}
