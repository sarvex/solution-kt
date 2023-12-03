internal class Solution {
  fun triangleNumber(nums: IntArray): Int {
    Arrays.sort(nums)
    val n = nums.size
    var res = 0
    for (i in n - 1 downTo 2) {
      var l = 0
      var r = i - 1
      while (l < r) {
        if (nums[l] + nums[r] > nums[i]) {
          res += r - l
          --r
        } else {
          ++l
        }
      }
    }
    return res
  }
}
