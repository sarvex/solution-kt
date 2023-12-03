import kotlin.math.min

internal class Solution {
  private var f: IntArray
  private var points: Array<IntArray>
  private var n = 0
  fun minimumLines(points: Array<IntArray>): Int {
    n = points.size
    this.points = points
    f = IntArray(1 shl n)
    return dfs(0)
  }

  private fun dfs(state: Int): Int {
    if (state == (1 shl n) - 1) {
      return 0
    }
    if (f[state] != 0) {
      return f[state]
    }
    var ans = 1 shl 30
    for (i in 0 until n) {
      if (state shr i and 1 == 0) {
        for (j in i + 1 until n) {
          var nxt = state or (1 shl i) or (1 shl j)
          for (k in j + 1 until n) {
            if (state shr k and 1 == 0 && check(i, j, k)) {
              nxt = nxt or (1 shl k)
            }
          }
          ans = min(ans.toDouble(), (dfs(nxt) + 1).toDouble()).toInt()
        }
        if (i == n - 1) {
          ans = min(ans.toDouble(), (dfs(state or (1 shl i)) + 1).toDouble()).toInt()
        }
      }
    }
    return ans.also { f[state] = it }
  }

  private fun check(i: Int, j: Int, k: Int): Boolean {
    val x1 = points[i][0]
    val y1 = points[i][1]
    val x2 = points[j][0]
    val y2 = points[j][1]
    val x3 = points[k][0]
    val y3 = points[k][1]
    return (x2 - x1) * (y3 - y1) == (x3 - x1) * (y2 - y1)
  }
}
