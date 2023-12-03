import kotlin.math.max

class Solution {
  private var n = 0
  private var c: Array<LongArray>
  private var balls: IntArray
  private val f: Map<List<Int>, Long> = HashMap()
  fun getProbability(balls: IntArray): Double {
    var mx = 0
    for (x in balls) {
      n += x
      mx = max(mx.toDouble(), x.toDouble()).toInt()
    }
    n = n shr 1
    this.balls = balls
    val m = max(mx.toDouble(), (n shl 1).toDouble()).toInt()
    c = Array(m + 1) { LongArray(m + 1) }
    for (i in 0..m) {
      c[i][0] = 1
      for (j in 1..i) {
        c[i][j] = c[i - 1][j - 1] + c[i - 1][j]
      }
    }
    return dfs(0, n, 0) * 1.0 / c[n shl 1][n]
  }

  private fun dfs(i: Int, j: Int, diff: Int): Long {
    if (i >= balls.size) {
      return if (j == 0 && diff == 0) 1 else 0
    }
    if (j < 0) {
      return 0
    }
    val key: List<Int> = List.of(i, j, diff)
    if (f.containsKey(key)) {
      return f[key]!!
    }
    var ans: Long = 0
    for (x in 0..balls[i]) {
      val y = if (x == balls[i]) 1 else if (x == 0) -1 else 0
      ans += dfs(i + 1, j - x, diff + y) * c[balls[i]][x]
    }
    f.put(key, ans)
    return ans
  }
}
