class Solution {
  private var n = 0
  private var f: IntArray
  private var nums: IntArray
  fun validPartition(nums: IntArray): Boolean {
    this.nums = nums
    n = nums.size
    f = IntArray(n)
    Arrays.fill(f, -1)
    return dfs(0)
  }

  private fun dfs(i: Int): Boolean {
    if (i == n) {
      return true
    }
    if (f[i] != -1) {
      return f[i] == 1
    }
    var res = false
    if (i < n - 1 && nums[i] == nums[i + 1]) {
      res = res || dfs(i + 2)
    }
    if (i < n - 2 && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
      res = res || dfs(i + 3)
    }
    if (i < n - 2 && nums[i + 1] - nums[i] == 1 && nums[i + 2] - nums[i + 1] == 1) {
      res = res || dfs(i + 3)
    }
    f[i] = if (res) 1 else 0
    return res
  }
}
