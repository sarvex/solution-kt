import kotlin.math.max
import kotlin.math.min

class Solution {
  private var s = 0
  private var s1 = 0
  private var n = 0
  private var ans = Int.MAX_VALUE
  private var nums: IntArray
  private var g: Array<List<Int>?>
  fun minimumScore(nums: IntArray, edges: Array<IntArray>): Int {
    n = nums.size
    g = arrayOfNulls(n)
    this.nums = nums
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    for (v in nums) {
      s = s xor v
    }
    for (i in 0 until n) {
      for (j in g[i]!!) {
        s1 = dfs(i, -1, j)
        dfs2(i, -1, j)
      }
    }
    return ans
  }

  private fun dfs(i: Int, fa: Int, x: Int): Int {
    var res = nums[i]
    for (j in g[i]!!) {
      if (j != fa && j != x) {
        res = res xor dfs(j, i, x)
      }
    }
    return res
  }

  private fun dfs2(i: Int, fa: Int, x: Int): Int {
    var res = nums[i]
    for (j in g[i]!!) {
      if (j != fa && j != x) {
        val a = dfs2(j, i, x)
        res = res xor a
        val b = s1 xor a
        val c = s xor s1
        val t = (max(max(a.toDouble(), b.toDouble()), c.toDouble()) - min(
          min(a.toDouble(), b.toDouble()),
          c.toDouble()
        )).toInt()
        ans = min(ans.toDouble(), t.toDouble()).toInt()
      }
    }
    return res
  }
}
