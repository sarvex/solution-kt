internal class Solution {
  private var nums: IntArray
  private var cur: IntArray
  private var s = 0
  fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
    for (v in nums) {
      s += v
    }
    if (s % k != 0) {
      return false
    }
    s /= k
    cur = IntArray(k)
    Arrays.sort(nums)
    this.nums = nums
    return dfs(nums.size - 1)
  }

  private fun dfs(i: Int): Boolean {
    if (i < 0) {
      return true
    }
    for (j in cur.indices) {
      if (j > 0 && cur[j] == cur[j - 1]) {
        continue
      }
      cur[j] += nums[i]
      if (cur[j] <= s && dfs(i - 1)) {
        return true
      }
      cur[j] -= nums[i]
    }
    return false
  }
}
