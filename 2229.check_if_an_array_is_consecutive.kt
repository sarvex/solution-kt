import kotlin.math.max
import kotlin.math.min

class Solution {
  fun isConsecutive(nums: IntArray): Boolean {
    var mi = nums[0]
    var mx = nums[0]
    val s: Set<Int> = HashSet()
    for (v in nums) {
      mi = min(mi.toDouble(), v.toDouble()).toInt()
      mx = max(mx.toDouble(), v.toDouble()).toInt()
      s.add(v)
    }
    val n = nums.size
    return s.size() === n && mx == mi + n - 1
  }
}
