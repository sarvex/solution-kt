class Solution {
  private var res = 0
  fun subsetXORSum(nums: IntArray): Int {
    dfs(nums, 0, 0)
    return res
  }

  private fun dfs(nums: IntArray, depth: Int, prev: Int) {
    var depth = depth
    var prev = prev
    res += prev
    for (i in depth until nums.size) {
      prev = prev xor nums[i]
      dfs(nums, ++depth, prev)
      prev = prev xor nums[i]
    }
  }
}
