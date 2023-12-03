import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.indices

internal class Solution {
  fun find132pattern(nums: IntArray): Boolean {
    var vk = -(1 shl 30)
    val stk: Deque<Int> = ArrayDeque()
    for (i in nums.indices.reversed()) {
      if (nums[i] < vk) {
        return true
      }
      while (!stk.isEmpty() && stk.peek() < nums[i]) {
        vk = stk.pop()
      }
      stk.push(nums[i])
    }
    return false
  }
}
