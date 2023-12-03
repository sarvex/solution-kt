internal class Solution {
  fun threeSum(nums: IntArray): List<List<Int>> {
    Arrays.sort(nums)
    val ans: List<List<Int>> = ArrayList()
    val n = nums.size
    var i = 0
    while (i < n - 2 && nums[i] <= 0) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        ++i
        continue
      }
      var j = i + 1
      var k = n - 1
      while (j < k) {
        val x = nums[i] + nums[j] + nums[k]
        if (x < 0) {
          ++j
        } else if (x > 0) {
          --k
        } else {
          ans.add(List.of(nums[i], nums[j++], nums[k--]))
          while (j < k && nums[j] == nums[j - 1]) {
            ++j
          }
          while (j < k && nums[k] == nums[k + 1]) {
            --k
          }
        }
      }
      ++i
    }
    return ans
  }
}
