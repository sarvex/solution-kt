import kotlin.math.max

class Solution {
  fun countTriplets(nums: IntArray): Int {
    var mx = 0
    for (x in nums) {
      mx = max(mx.toDouble(), x.toDouble()).toInt()
    }
    val cnt = IntArray(mx + 1)
    for (x in nums) {
      for (y in nums) {
        cnt[x and y]++
      }
    }
    var ans = 0
    for (xy in 0..mx) {
      for (z in nums) {
        if (xy and z == 0) {
          ans += cnt[xy]
        }
      }
    }
    return ans
  }
}
