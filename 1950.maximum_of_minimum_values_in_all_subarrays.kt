import java.util.Deque
import kotlin.collections.ArrayDeque
import kotlin.math.max

class Solution {
  fun findMaximums(nums: IntArray): IntArray {
    val n = nums.size
    val left = IntArray(n)
    val right = IntArray(n)
    Arrays.fill(left, -1)
    Arrays.fill(right, n)
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
    stk.clear()
    for (i in n - 1 downTo 0) {
      while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        right[i] = stk.peek()
      }
      stk.push(i)
    }
    val ans = IntArray(n)
    for (i in 0 until n) {
      val m = right[i] - left[i] - 1
      ans[m - 1] = max(ans[m - 1].toDouble(), nums[i].toDouble()).toInt()
    }
    for (i in n - 2 downTo 0) {
      ans[i] = max(ans[i].toDouble(), ans[i + 1].toDouble()).toInt()
    }
    return ans
  }
}
