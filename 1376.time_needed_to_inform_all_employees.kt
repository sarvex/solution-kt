import kotlin.math.max

class Solution {
  private var g: Array<List<Int>?>
  private var informTime: IntArray
  fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    this.informTime = informTime
    for (i in 0 until n) {
      if (manager[i] >= 0) {
        g[manager[i]].add(i)
      }
    }
    return dfs(headID)
  }

  private fun dfs(i: Int): Int {
    var ans = 0
    for (j in g[i]!!) {
      ans = max(ans.toDouble(), (dfs(j) + informTime[i]).toDouble()).toInt()
    }
    return ans
  }
}
