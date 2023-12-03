import kotlin.math.abs

class Solution {
  private var locations: IntArray
  private var finish = 0
  private var n = 0
  private var f: Array<Array<Int>>
  private val mod = 1e9.toInt() + 7
  fun countRoutes(locations: IntArray, start: Int, finish: Int, fuel: Int): Int {
    n = locations.size
    this.locations = locations
    this.finish = finish
    f = Array(n) { arrayOfNulls(fuel + 1) }
    return dfs(start, fuel)
  }

  private fun dfs(i: Int, k: Int): Int {
    if (k < abs((locations[i] - locations[finish]).toDouble())) {
      return 0
    }
    if (f[i][k] != null) {
      return f[i][k]
    }
    var ans = if (i == finish) 1 else 0
    for (j in 0 until n) {
      if (j != i) {
        ans = (ans + dfs(j, (k - abs((locations[i] - locations[j]).toDouble())).toInt())) % mod
      }
    }
    return ans.also { f[i][k] = it }
  }
}
