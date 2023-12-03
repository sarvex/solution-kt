import kotlin.math.max
import kotlin.math.min

class Solution {
  fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
    val ans: List<Boolean> = ArrayList()
    for (i in l.indices) {
      ans.add(check(nums, l[i], r[i]))
    }
    return ans
  }

  private fun check(nums: IntArray, l: Int, r: Int): Boolean {
    val s: Set<Int> = HashSet()
    val n = r - l + 1
    var a1 = 1 shl 30
    var an = -a1
    for (i in l..r) {
      s.add(nums[i])
      a1 = min(a1.toDouble(), nums[i].toDouble()).toInt()
      an = max(an.toDouble(), nums[i].toDouble()).toInt()
    }
    if ((an - a1) % (n - 1) != 0) {
      return false
    }
    val d = (an - a1) / (n - 1)
    for (i in 1 until n) {
      if (!s.contains(a1 + (i - 1) * d)) {
        return false
      }
    }
    return true
  }
}
