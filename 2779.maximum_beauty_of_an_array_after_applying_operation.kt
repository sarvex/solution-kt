import kotlin.math.max

class Solution {
  fun maximumBeauty(nums: IntArray, k: Int): Int {
    val m: Int = Arrays.stream(nums).max().getAsInt() + k * 2 + 2
    val d = IntArray(m)
    for (x in nums) {
      d[x]++
      d[x + k * 2 + 1]--
    }
    var ans = 0
    var s = 0
    for (x in d) {
      s += x
      ans = max(ans.toDouble(), s.toDouble()).toInt()
    }
    return ans
  }
}
