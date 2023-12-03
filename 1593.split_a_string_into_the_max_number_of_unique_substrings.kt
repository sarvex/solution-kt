import kotlin.math.max

class Solution {
  private val vis: Set<String> = HashSet()
  private var ans = 1
  private var s: String? = null
  fun maxUniqueSplit(s: String?): Int {
    this.s = s
    dfs(0, 0)
    return ans
  }

  private fun dfs(i: Int, t: Int) {
    if (i >= s!!.length) {
      ans = max(ans.toDouble(), t.toDouble()).toInt()
      return
    }
    for (j in i + 1..s!!.length) {
      val x = s!!.substring(i, j)
      if (vis.add(x)) {
        dfs(j, t + 1)
        vis.remove(x)
      }
    }
  }
}
