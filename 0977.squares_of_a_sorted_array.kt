class Solution {
  fun sortedSquares(nums: IntArray): IntArray {
    val n = nums.size
    val res = IntArray(n)
    var i = 0
    var j = n - 1
    var k = n - 1
    while (i <= j) {
      if (nums[i] * nums[i] > nums[j] * nums[j]) {
        res[k--] = nums[i] * nums[i]
        ++i
      } else {
        res[k--] = nums[j] * nums[j]
        --j
      }
    }
    return res
  }
}
