internal class Solution {
  fun nextGreaterElements(nums: IntArray): IntArray {
    val n = nums.size
    val ans = IntArray(n)
    Arrays.fill(ans, -1)
    val stk: Deque<Int> = ArrayDeque()
    for (i in 0 until (n shl 1)) {
      while (!stk.isEmpty() && nums[stk.peek()] < nums[i % n]) {
        ans[stk.pop()] = nums[i % n]
      }
      stk.push(i % n)
    }
    return ans
  }
}
