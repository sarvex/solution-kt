class Solution {
  fun maxScoreIndices(nums: IntArray): List<Int> {
    var left = 0
    var right = sum(nums)
    var mx = right
    val ans: List<Int> = ArrayList()
    ans.add(0)
    for (i in nums.indices) {
      if (nums[i] == 0) {
        ++left
      } else {
        --right
      }
      val t = left + right
      if (mx == t) {
        ans.add(i + 1)
      } else if (mx < t) {
        mx = t
        ans.clear()
        ans.add(i + 1)
      }
    }
    return ans
  }

  private fun sum(nums: IntArray): Int {
    var s = 0
    for (num in nums) {
      s += num
    }
    return s
  }
}
