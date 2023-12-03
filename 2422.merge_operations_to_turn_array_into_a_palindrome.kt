class Solution {
  fun minimumOperations(nums: IntArray): Int {
    var i = 0
    var j = nums.size - 1
    var a = nums[i].toLong()
    var b = nums[j].toLong()
    var ans = 0
    while (i < j) {
      if (a < b) {
        a += nums[++i].toLong()
        ++ans
      } else if (b < a) {
        b += nums[--j].toLong()
        ++ans
      } else {
        a = nums[++i].toLong()
        b = nums[--j].toLong()
      }
    }
    return ans
  }
}
