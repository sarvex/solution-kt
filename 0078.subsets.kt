internal class Solution {
  private val ans: List<List<Int>> = ArrayList()
  private val t: List<Int> = ArrayList()
  private var nums: IntArray
  fun subsets(nums: IntArray): List<List<Int>> {
    this.nums = nums
    dfs(0)
    return ans
  }

  private fun dfs(i: Int) {
    if (i == nums.size) {
      ans.add(ArrayList(t))
      return
    }
    dfs(i + 1)
    t.add(nums[i])
    dfs(i + 1)
    t.remove(t.size() - 1)
  }
}
