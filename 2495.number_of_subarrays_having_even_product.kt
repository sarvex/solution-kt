class Solution {
  fun evenProduct(nums: IntArray): Long {
    var ans: Long = 0
    var last = -1
    for (i in nums.indices) {
      if (nums[i] % 2 == 0) {
        last = i
      }
      ans += (last + 1).toLong()
    }
    return ans
  }
}
