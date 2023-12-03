import kotlin.math.abs

internal class Solution {
  fun fractionAddition(expression: String): String {
    var expression = expression
    var x = 0
    var y = 6 * 7 * 8 * 9 * 10
    if (Character.isDigit(expression[0])) {
      expression = "+$expression"
    }
    var i = 0
    val n = expression.length
    while (i < n) {
      val sign = if (expression[i] == '-') -1 else 1
      ++i
      var j = i
      while (j < n && expression[j] != '+' && expression[j] != '-') {
        ++j
      }
      val s = expression.substring(i, j)
      val t = s.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
      val a = t[0].toInt()
      val b = t[1].toInt()
      x += sign * a * y / b
      i = j
    }
    val z = gcd(abs(x.toDouble()).toInt(), y)
    x /= z
    y /= z
    return "$x/$y"
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
