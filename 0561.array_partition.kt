internal class Solution {
  fun arrayPairSum(nums: IntArray): Int {
    Arrays.sort(nums)
    var ans = 0
    var i = 0
    while (i < nums.size) {
      ans += nums[i]
      i += 2
    }
    return ans
  }
}
