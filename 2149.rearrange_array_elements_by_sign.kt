internal class Solution {
  fun rearrangeArray(nums: IntArray): IntArray {
    val ans = IntArray(nums.size)
    var i = 0
    var j = 1
    for (num in nums) {
      if (num > 0) {
        ans[i] = num
        i += 2
      } else {
        ans[j] = num
        j += 2
      }
    }
    return ans
  }
}
