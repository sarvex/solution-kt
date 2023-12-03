internal class Solution {
  private var ans: List<List<Int>>? = null
  private var nums: IntArray
  fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    ans = ArrayList()
    Arrays.sort(nums)
    this.nums = nums
    dfs(0, ArrayList())
    return ans
  }

  private fun dfs(u: Int, t: List<Int>) {
    ans.add(ArrayList(t))
    for (i in u until nums.size) {
      if (i != u && nums[i] == nums[i - 1]) {
        continue
      }
      t.add(nums[i])
      dfs(i + 1, t)
      t.remove(t.size() - 1)
    }
  }
}
