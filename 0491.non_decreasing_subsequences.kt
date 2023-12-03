internal class Solution {
  private var nums: IntArray
  private var ans: List<List<Int>>? = null
  fun findSubsequences(nums: IntArray): List<List<Int>> {
    this.nums = nums
    ans = ArrayList()
    dfs(0, -1000, ArrayList())
    return ans
  }

  private fun dfs(u: Int, last: Int, t: List<Int>) {
    if (u == nums.size) {
      if (t.size() > 1) {
        ans.add(ArrayList(t))
      }
      return
    }
    if (nums[u] >= last) {
      t.add(nums[u])
      dfs(u + 1, nums[u], t)
      t.remove(t.size() - 1)
    }
    if (nums[u] != last) {
      dfs(u + 1, last, t)
    }
  }
}
