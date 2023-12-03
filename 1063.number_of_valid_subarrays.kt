import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun validSubarrays(nums: IntArray): Int {
    val n = nums.size
    val stk: Deque<Int> = ArrayDeque()
    var ans = 0
    for (i in n - 1 downTo 0) {
      while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
        stk.pop()
      }
      ans += (if (stk.isEmpty()) n else stk.peek()) - i
      stk.push(i)
    }
    return ans
  }
}
