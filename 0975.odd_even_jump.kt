import java.util.*

class Solution {
  private var n = 0
  private var f: Array<Array<Int>>
  private var g: Array<IntArray>
  fun oddEvenJumps(arr: IntArray): Int {
    val tm: TreeMap<Int, Int> = TreeMap()
    n = arr.size
    f = Array(n) { arrayOfNulls(2) }
    g = Array(n) { IntArray(2) }
    for (i in n - 1 downTo 0) {
      val hi: Unit = tm.ceilingEntry(arr[i])
      g[i][1] = if (hi == null) -1 else hi.getValue()
      val lo: Unit = tm.floorEntry(arr[i])
      g[i][0] = if (lo == null) -1 else lo.getValue()
      tm[arr[i]] = i
    }
    var ans = 0
    for (i in 0 until n) {
      ans += dfs(i, 1)
    }
    return ans
  }

  private fun dfs(i: Int, k: Int): Int {
    if (i == n - 1) {
      return 1
    }
    if (g[i][k] == -1) {
      return 0
    }
    return if (f[i][k] != null) {
      f[i][k]
    } else dfs(g[i][k], k xor 1).also { f[i][k] = it }
  }
}
