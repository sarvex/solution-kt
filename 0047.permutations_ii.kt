internal class Solution {
  private val ans: List<List<Int>> = ArrayList()
  private val t: List<Int> = ArrayList()
  private var nums: IntArray
  private var vis: BooleanArray
  fun permuteUnique(nums: IntArray): List<List<Int>> {
    Arrays.sort(nums)
    this.nums = nums
    vis = BooleanArray(nums.size)
    dfs(0)
    return ans
  }

  private fun dfs(i: Int) {
    if (i == nums.size) {
      ans.add(ArrayList(t))
      return
    }
    for (j in nums.indices) {
      if (vis[j] || j > 0 && nums[j] == nums[j - 1] && !vis[j - 1]) {
        continue
      }
      t.add(nums[j])
      vis[j] = true
      dfs(i + 1)
      vis[j] = false
      t.remove(t.size() - 1)
    }
  }
}
