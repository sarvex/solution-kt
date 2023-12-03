internal class Solution {
  fun sortArrayByParity(nums: IntArray): IntArray {
    var i = 0
    var j = nums.size - 1
    while (i < j) {
      if (nums[i] % 2 == 1) {
        val t = nums[i]
        nums[i] = nums[j]
        nums[j] = t
        --j
      } else {
        ++i
      }
    }
    return nums
  }
}
