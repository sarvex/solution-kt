class Solution {
  private var mx = 0
  private var ans = 0
  private var nums: IntArray
  fun countMaxOrSubsets(nums: IntArray): Int {
    mx = 0
    for (x in nums) {
      mx = mx or x
    }
    this.nums = nums
    dfs(0, 0)
    return ans
  }

  private fun dfs(i: Int, t: Int) {
    if (i == nums.size) {
      if (t == mx) {
        ++ans
      }
      return
    }
    dfs(i + 1, t)
    dfs(i + 1, t or nums[i])
  }
}
