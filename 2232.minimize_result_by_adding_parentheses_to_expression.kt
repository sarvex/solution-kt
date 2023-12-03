class Solution {
  fun minimizeResult(expression: String): String {
    val idx = expression.indexOf('+')
    val l = expression.substring(0, idx)
    val r = expression.substring(idx + 1)
    val m = l.length
    val n = r.length
    var mi = Int.MAX_VALUE
    var ans = ""
    for (i in 0 until m) {
      for (j in 0 until n) {
        val c = l.substring(i).toInt() + r.substring(0, j + 1).toInt()
        val a = if (i == 0) 1 else l.substring(0, i).toInt()
        val b = if (j == n - 1) 1 else r.substring(j + 1).toInt()
        val t = a * b * c
        if (t < mi) {
          mi = t
          ans = String.format(
            "%s(%s+%s)%s", l.substring(0, i), l.substring(i),
            r.substring(0, j + 1), r.substring(j + 1)
          )
        }
      }
    }
    return ans
  }
}
