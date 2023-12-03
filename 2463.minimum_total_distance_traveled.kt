import kotlin.math.min

class Solution {
  private var f: Array<LongArray>
  private var robot: List<Int>? = null
  private var factory: Array<IntArray>
  fun minimumTotalDistance(robot: List<Int>, factory: Array<IntArray>): Long {
    Collections.sort(robot)
    Arrays.sort(factory) { a, b -> a.get(0) - b.get(0) }
    this.robot = robot
    this.factory = factory
    f = Array(robot.size()) { LongArray(factory.size) }
    return dfs(0, 0)
  }

  private fun dfs(i: Int, j: Int): Long {
    if (i == robot!!.size()) {
      return 0
    }
    if (j == factory.size) {
      return Long.MAX_VALUE / 1000
    }
    if (f[i][j] != 0L) {
      return f[i][j]
    }
    var ans = dfs(i, j + 1)
    var t: Long = 0
    for (k in 0 until factory[j][1]) {
      if (i + k == robot!!.size()) {
        break
      }
      t += Math.abs(robot!![i + k] - factory[j][0])
      ans = min(ans.toDouble(), (t + dfs(i + k + 1, j + 1)).toDouble()).toLong()
    }
    f[i][j] = ans
    return ans
  }
}
