internal class Solution {
  private var g: Array<List<Int>?>
  private var vis: BooleanArray
  private var has: BooleanArray
  private var nums: IntArray
  fun smallestMissingValueSubtree(parents: IntArray, nums: IntArray): IntArray {
    val n = nums.size
    this.nums = nums
    g = arrayOfNulls(n)
    vis = BooleanArray(n)
    has = BooleanArray(n + 2)
    Arrays.setAll(g) { i -> ArrayList() }
    var idx = -1
    for (i in 0 until n) {
      if (i > 0) {
        g[parents[i]].add(i)
      }
      if (nums[i] == 1) {
        idx = i
      }
    }
    val ans = IntArray(n)
    Arrays.fill(ans, 1)
    if (idx == -1) {
      return ans
    }
    var i = 2
    while (idx != -1) {
      dfs(idx)
      while (has[i]) {
        ++i
      }
      ans[idx] = i
      idx = parents[idx]
    }
    return ans
  }

  private fun dfs(i: Int) {
    if (vis[i]) {
      return
    }
    vis[i] = true
    if (nums[i] < has.size) {
      has[nums[i]] = true
    }
    for (j in g[i]!!) {
      dfs(j)
    }
  }
}
