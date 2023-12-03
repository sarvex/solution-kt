internal class Solution {
  fun threeSumSmaller(nums: IntArray, target: Int): Int {
    Arrays.sort(nums)
    var ans = 0
    var i = 0
    val n = nums.size
    while (i < n) {
      var j = i + 1
      var k = n - 1
      while (j < k) {
        val s = nums[i] + nums[j] + nums[k]
        if (s >= target) {
          --k
        } else {
          ans += k - j
          ++j
        }
      }
      ++i
    }
    return ans
  }
}
