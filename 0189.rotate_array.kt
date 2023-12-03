internal class Solution {
  private var nums: IntArray
  fun rotate(nums: IntArray, k: Int) {
    var k = k
    this.nums = nums
    val n = nums.size
    k %= n
    reverse(0, n - 1)
    reverse(0, k - 1)
    reverse(k, n - 1)
  }

  private fun reverse(i: Int, j: Int) {
    var i = i
    var j = j
    while (i < j) {
      val t = nums[i]
      nums[i] = nums[j]
      nums[j] = t
      ++i
      --j
    }
  }
}
