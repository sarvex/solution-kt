class Solution {
  fun reductionOperations(nums: IntArray): Int {
    Arrays.sort(nums)
    var ans = 0
    var cnt = 0
    for (i in 1 until nums.size) {
      if (nums[i] != nums[i - 1]) {
        ++cnt
      }
      ans += cnt
    }
    return ans
  }
}
