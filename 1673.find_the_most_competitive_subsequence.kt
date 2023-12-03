import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.indices

class Solution {
  fun mostCompetitive(nums: IntArray, k: Int): IntArray {
    val stk: Deque<Int> = ArrayDeque()
    val n = nums.size
    for (i in nums.indices) {
      while (!stk.isEmpty() && stk.peek() > nums[i] && stk.size() + n - i > k) {
        stk.pop()
      }
      if (stk.size() < k) {
        stk.push(nums[i])
      }
    }
    val ans = IntArray(stk.size())
    for (i in ans.indices.reversed()) {
      ans[i] = stk.pop()
    }
    return ans
  }
}
