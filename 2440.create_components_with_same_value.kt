import kotlin.math.min

class Solution {
  private var g: Array<List<Int>?>
  private var nums: IntArray
  private var t = 0
  fun componentValue(nums: IntArray, edges: Array<IntArray>): Int {
    val n = nums.size
    g = arrayOfNulls(n)
    this.nums = nums
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    val s = sum(nums)
    val mx = max(nums)
    for (k in min(n.toDouble(), (s / mx).toDouble()) downTo 2) {
      if (s % k == 0) {
        t = s / k
        if (dfs(0, -1) == 0) {
          return k - 1
        }
      }
    }
    return 0
  }

  private fun dfs(i: Int, fa: Int): Int {
    var x = nums[i]
    for (j in g[i]!!) {
      if (j != fa) {
        val y = dfs(j, i)
        if (y == -1) {
          return -1
        }
        x += y
      }
    }
    if (x > t) {
      return -1
    }
    return if (x < t) x else 0
  }

  private fun sum(arr: IntArray): Int {
    var x = 0
    for (v in arr) {
      x += v
    }
    return x
  }

  private fun max(arr: IntArray): Int {
    var x = arr[0]
    for (v in arr) {
      x = kotlin.math.max(x.toDouble(), v.toDouble()).toInt()
    }
    return x
  }
}
