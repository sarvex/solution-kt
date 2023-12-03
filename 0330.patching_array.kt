internal class Solution {
  fun minPatches(nums: IntArray, n: Int): Int {
    var x: Long = 1
    var ans = 0
    var i = 0
    while (x <= n) {
      if (i < nums.size && nums[i] <= x) {
        x += nums[i++].toLong()
      } else {
        ++ans
        x = x shl 1
      }
    }
    return ans
  }
}
