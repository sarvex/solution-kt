import kotlin.math.max

class Solution {
  private var g: Array<IntArray>
  private var vis: BooleanArray
  private var m = 0
  private var ans = 0
  fun maxCompatibilitySum(students: Array<IntArray>, mentors: Array<IntArray>): Int {
    m = students.size
    g = Array(m) { IntArray(m) }
    vis = BooleanArray(m)
    for (i in 0 until m) {
      for (j in 0 until m) {
        for (k in students[i].indices) {
          g[i][j] += if (students[i][k] == mentors[j][k]) 1 else 0
        }
      }
    }
    dfs(0, 0)
    return ans
  }

  private fun dfs(i: Int, t: Int) {
    if (i == m) {
      ans = max(ans.toDouble(), t.toDouble()).toInt()
      return
    }
    for (j in 0 until m) {
      if (!vis[j]) {
        vis[j] = true
        dfs(i + 1, t + g[i][j])
        vis[j] = false
      }
    }
  }
}
