internal class Solution {
  fun summaryRanges(nums: IntArray): List<String> {
    val ans: List<String> = ArrayList()
    var i = 0
    var j: Int
    val n = nums.size
    while (i < n) {
      j = i
      while (j + 1 < n && nums[j + 1] == nums[j] + 1) {
        ++j
      }
      ans.add(f(nums, i, j))
      i = j + 1
    }
    return ans
  }

  private fun f(nums: IntArray, i: Int, j: Int): String {
    return if (i == j) nums[i].toString() + "" else String.format("%d->%d", nums[i], nums[j])
  }
}
