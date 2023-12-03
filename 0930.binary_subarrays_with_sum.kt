internal class Solution {
  fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
    var i1 = 0
    var i2 = 0
    var s1 = 0
    var s2 = 0
    var j = 0
    var ans = 0
    val n = nums.size
    while (j < n) {
      s1 += nums[j]
      s2 += nums[j]
      while (i1 <= j && s1 > goal) {
        s1 -= nums[i1++]
      }
      while (i2 <= j && s2 >= goal) {
        s2 -= nums[i2++]
      }
      ans += i2 - i1
      ++j
    }
    return ans
  }
}
