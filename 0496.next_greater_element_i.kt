import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap
import kotlin.collections.Map

internal class Solution {
  fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val stk: Deque<Int> = ArrayDeque()
    val mp: Map<Int, Int> = HashMap()
    for (num in nums2) {
      while (!stk.isEmpty() && stk.peek() < num) {
        mp.put(stk.pop(), num)
      }
      stk.push(num)
    }
    val n = nums1.size
    val ans = IntArray(n)
    for (i in 0 until n) {
      ans[i] = mp[nums1[i]] ?: -1
    }
    return ans
  }
}
