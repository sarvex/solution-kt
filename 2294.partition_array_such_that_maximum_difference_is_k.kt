class Solution {
  fun partitionArray(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    var ans = 1
    var a = nums[0]
    for (b in nums) {
      if (b - a > k) {
        a = b
        ++ans
      }
    }
    return ans
  }
}
