internal class Solution {
  private var f: Array<Array<Boolean>>
  private val pos: Map<Int, Int> = HashMap()
  private var stones: IntArray
  private var n = 0
  fun canCross(stones: IntArray): Boolean {
    n = stones.size
    f = Array(n) { arrayOfNulls(n) }
    this.stones = stones
    for (i in 0 until n) {
      pos.put(stones[i], i)
    }
    return dfs(0, 0)
  }

  private fun dfs(i: Int, k: Int): Boolean {
    if (i == n - 1) {
      return true
    }
    if (f[i][k] != null) {
      return f[i][k]
    }
    for (j in k - 1..k + 1) {
      if (j > 0) {
        val h = stones[i] + j
        if (pos.containsKey(h) && dfs(pos[h]!!, j)) {
          return true.also { f[i][k] = it }
        }
      }
    }
    return false.also { f[i][k] = it }
  }
}
