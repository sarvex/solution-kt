class Solution {
  fun rearrangeArray(nums: IntArray): IntArray {
    Arrays.sort(nums)
    val n = nums.size
    val m = n + 1 shr 1
    val ans = IntArray(n)
    var i = 0
    var j = 0
    while (i < n) {
      ans[i] = nums[j]
      if (j + m < n) {
        ans[i + 1] = nums[j + m]
      }
      i += 2
      j++
    }
    return ans
  }
}
