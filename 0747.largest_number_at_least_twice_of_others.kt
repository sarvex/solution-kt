internal class Solution {
  fun dominantIndex(nums: IntArray): Int {
    var mx = Int.MIN_VALUE
    var mid = Int.MIN_VALUE
    var ans = -1
    for (i in nums.indices) {
      if (nums[i] > mx) {
        mid = mx
        mx = nums[i]
        ans = i
      } else if (nums[i] > mid) {
        mid = nums[i]
      }
    }
    return if (mx >= mid * 2) ans else -1
  }
}
