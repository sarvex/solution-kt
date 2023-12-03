internal class Solution {
  private val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
  private var blocked: Set<Int>? = null
  fun isEscapePossible(blocked: Array<IntArray>, source: IntArray, target: IntArray): Boolean {
    this.blocked = HashSet()
    for (b in blocked) {
      this.blocked.add(b[0] * Solution.Companion.N + b[1])
    }
    return dfs(source, target, HashSet()) && dfs(target, source, HashSet())
  }

  private fun dfs(source: IntArray, target: IntArray, seen: Set<Int>): Boolean {
    val sx = source[0]
    val sy = source[1]
    val tx = target[0]
    val ty = target[1]
    if (sx < 0 || sx >= Solution.Companion.N || sy < 0 || sy >= Solution.Companion.N || tx < 0 || tx >= Solution.Companion.N || ty < 0 || ty >= Solution.Companion.N || blocked!!.contains(
        sx * Solution.Companion.N + sy
      ) || seen.contains(sx * Solution.Companion.N + sy)
    ) {
      return false
    }
    seen.add(sx * Solution.Companion.N + sy)
    if (seen.size() > 20000 || sx == target[0] && sy == target[1]) {
      return true
    }
    for (dir in dirs) {
      if (dfs(intArrayOf(sx + dir[0], sy + dir[1]), target, seen)) {
        return true
      }
    }
    return false
  }

  companion object {
    private const val N = 1e6.toInt()
  }
}
