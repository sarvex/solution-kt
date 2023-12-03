class Solution {
  fun largestNumber(cost: IntArray, target: Int): String {
    val inf = 1 shl 30
    val f = Array(10) { IntArray(target + 1) }
    val g = Array(10) { IntArray(target + 1) }
    for (e in f) {
      Arrays.fill(e, -inf)
    }
    f[0][0] = 0
    for (i in 1..9) {
      val c = cost[i - 1]
      for (j in 0..target) {
        if (j < c || f[i][j - c] + 1 < f[i - 1][j]) {
          f[i][j] = f[i - 1][j]
          g[i][j] = j
        } else {
          f[i][j] = f[i][j - c] + 1
          g[i][j] = j - c
        }
      }
    }
    if (f[9][target] < 0) {
      return "0"
    }
    val sb = StringBuilder()
    var i = 9
    var j = target
    while (i > 0) {
      if (j == g[i][j]) {
        --i
      } else {
        sb.append(i)
        j = g[i][j]
      }
    }
    return sb.toString()
  }
}
