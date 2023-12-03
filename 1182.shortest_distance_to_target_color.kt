import kotlin.math.min

internal class Solution {
  fun shortestDistanceColor(colors: IntArray, queries: Array<IntArray>): List<Int> {
    val n = colors.size
    val inf = 1 shl 30
    val right = Array(n + 1) { IntArray(3) }
    Arrays.fill(right[n], inf)
    for (i in n - 1 downTo 0) {
      for (j in 0..2) {
        right[i][j] = right[i + 1][j]
      }
      right[i][colors[i] - 1] = i
    }
    val left = Array(n + 1) { IntArray(3) }
    Arrays.fill(left[0], -inf)
    for (i in 1..n) {
      for (j in 0..2) {
        left[i][j] = left[i - 1][j]
      }
      left[i][colors[i - 1] - 1] = i - 1
    }
    val ans: List<Int> = ArrayList()
    for (q in queries) {
      val i = q[0]
      val c = q[1] - 1
      val d = min((i - left[i + 1][c]).toDouble(), (right[i][c] - i).toDouble())
        .toInt()
      ans.add(if (d > n) -1 else d)
    }
    return ans
  }
}
