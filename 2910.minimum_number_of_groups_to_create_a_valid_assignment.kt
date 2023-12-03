import kotlin.math.min

class Solution {
  fun minGroupsForValidAssignment(nums: IntArray): Int {
    val cnt: Map<Int, Int> = HashMap()
    for (x in nums) {
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var k = nums.size
    for (v in cnt.values()) {
      k = min(k.toDouble(), v.toDouble()).toInt()
    }
    while (true) {
      var ans = 0
      for (v in cnt.values()) {
        if (v / k < v % k) {
          ans = 0
          break
        }
        ans += (v + k) / (k + 1)
      }
      if (ans > 0) {
        return ans
      }
      --k
    }
  }
}
