internal class Solution {
  fun solveEquation(equation: String): String {
    val es = equation.split("=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val a = f(es[0])
    val b = f(es[1])
    val x1 = a[0]
    val y1 = a[1]
    val x2 = b[0]
    val y2 = b[1]
    return if (x1 == x2) {
      if (y1 == y2) "Infinite solutions" else "No solution"
    } else "x=" + (y2 - y1) / (x1 - x2)
  }

  private fun f(s: String): IntArray {
    var s = s
    var x = 0
    var y = 0
    if (s[0] != '-') {
      s = "+$s"
    }
    var i = 0
    val n = s.length
    while (i < n) {
      val sign = if (s[i] == '+') 1 else -1
      ++i
      var j = i
      while (j < n && s[j] != '+' && s[j] != '-') {
        ++j
      }
      val v = s.substring(i, j)
      if (s[j - 1] == 'x') {
        x += sign * if (v.length > 1) v.substring(0, v.length - 1).toInt() else 1
      } else {
        y += sign * v.toInt()
      }
      i = j
    }
    return intArrayOf(x, y)
  }
}
