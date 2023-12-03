import kotlin.math.abs
import kotlin.math.min

class Solution {
  fun minCost(basket1: IntArray, basket2: IntArray): Long {
    val n = basket1.size
    val cnt: Map<Int, Int> = HashMap()
    for (i in 0 until n) {
      cnt.merge(basket1[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      cnt.merge(basket2[i], -1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var mi = 1 shl 30
    val nums: List<Int> = ArrayList()
    for (e in cnt.entrySet()) {
      val x: Int = e.getKey()
      val v: Int = e.getValue()
      if (v % 2 != 0) {
        return -1
      }
      for (i in abs(v.toDouble()) / 2 downTo 1) {
        nums.add(x)
      }
      mi = min(mi.toDouble(), x.toDouble()).toInt()
    }
    Collections.sort(nums)
    val m: Int = nums.size()
    var ans: Long = 0
    for (i in 0 until m / 2) {
      ans += Math.min(nums[i], mi * 2)
    }
    return ans
  }
}
