import kotlin.math.max

class Solution {
  fun maximumTripletValue(nums: IntArray): Long {
    var max: Long
    var maxDiff: Long
    var ans: Long
    max = 0
    maxDiff = 0
    ans = 0
    for (num in nums) {
      ans = max(ans.toDouble(), (num * maxDiff).toDouble()).toLong()
      max = max(max.toDouble(), num.toDouble()).toLong()
      maxDiff = max(maxDiff.toDouble(), (max - num).toDouble()).toLong()
    }
    return ans
  }
}
