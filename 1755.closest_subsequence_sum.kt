class Solution {
  fun minAbsDifference(nums: IntArray, goal: Int): Int {
    val n = nums.size
    val lsum: List<Int> = ArrayList()
    val rsum: List<Int> = ArrayList()
    dfs(nums, lsum, 0, n / 2, 0)
    dfs(nums, rsum, n / 2, n, 0)
    rsum.sort(Integer::compareTo)
    var res = Int.MAX_VALUE
    for (x in lsum) {
      val target = goal - x
      var left = 0
      var right: Int = rsum.size()
      while (left < right) {
        val mid = left + right shr 1
        if (rsum[mid] < target) {
          left = mid + 1
        } else {
          right = mid
        }
      }
      if (left < rsum.size()) {
        res = Math.min(res, Math.abs(target - rsum[left]))
      }
      if (left > 0) {
        res = Math.min(res, Math.abs(target - rsum[left - 1]))
      }
    }
    return res
  }

  private fun dfs(nums: IntArray, sum: List<Int>, i: Int, n: Int, cur: Int) {
    if (i == n) {
      sum.add(cur)
      return
    }
    dfs(nums, sum, i + 1, n, cur)
    dfs(nums, sum, i + 1, n, cur + nums[i])
  }
}
