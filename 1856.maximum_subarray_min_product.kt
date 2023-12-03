import java.util.Deque
import kotlin.collections.ArrayDeque
import kotlin.math.max

class Solution {
  fun maxSumMinProduct(nums: IntArray): Int {
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
      while (!stk.isEmpty() && nums[stk.peek()] > nums[i]) {
        stk.pop()
      }
      if (!stk.isEmpty()) {
        right[i] = stk.peek()
      }
      stk.push(i)
    }
    val s = LongArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
    var ans: Long = 0
    for (i in 0 until n) {
      ans = max(ans.toDouble(), (nums[i] * (s[right[i]] - s[left[i] + 1])).toDouble())
        .toLong()
    }
    val mod = 1e9.toInt() + 7
    return (ans % mod).toInt()
  }
}
