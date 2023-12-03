import kotlin.math.min

class Solution {
  private var f: Array<Int>
  private var nums: IntArray
  private var n = 0
  private var k = 0
  fun minCost(nums: IntArray, k: Int): Int {
    n = nums.size
    this.k = k
    this.nums = nums
    f = arrayOfNulls(n)
    return dfs(0)
  }

  private fun dfs(i: Int): Int {
    if (i >= n) {
      return 0
    }
    if (f[i] != null) {
      return f[i]
    }
    val cnt = IntArray(n)
    var one = 0
    var ans = 1 shl 30
    for (j in i until n) {
      val x = ++cnt[nums[j]]
      if (x == 1) {
        ++one
      } else if (x == 2) {
        --one
      }
      ans = min(ans.toDouble(), (k + j - i + 1 - one + dfs(j + 1)).toDouble()).toInt()
    }
    return ans.also { f[i] = it }
  }
}
