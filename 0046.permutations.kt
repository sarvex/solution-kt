internal class Solution {
  private val ans: List<List<Int>> = ArrayList()
  private val t: List<Int> = ArrayList()
  private var vis: BooleanArray
  private var nums: IntArray
  fun permute(nums: IntArray): List<List<Int>> {
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
      if (!vis[j]) {
        vis[j] = true
        t.add(nums[j])
        dfs(i + 1)
        t.remove(t.size() - 1)
        vis[j] = false
      }
    }
  }
}
