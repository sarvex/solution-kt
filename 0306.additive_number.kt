import kotlin.math.min

internal class Solution {
  fun isAdditiveNumber(num: String): Boolean {
    val n = num.length
    for (i in 1 until min((n - 1).toDouble(), 19.0).toInt()) {
      for (j in i + 1 until min(n.toDouble(), (i + 19).toDouble()).toInt()) {
        if (i > 1 && num[0] == '0') {
          break
        }
        if (j - i > 1 && num[i] == '0') {
          continue
        }
        val a = num.substring(0, i).toLong()
        val b = num.substring(i, j).toLong()
        if (dfs(a, b, num.substring(j))) {
          return true
        }
      }
    }
    return false
  }

  private fun dfs(a: Long, b: Long, num: String): Boolean {
    if ("" == num) {
      return true
    }
    if (a + b > 0 && num[0] == '0') {
      return false
    }
    for (i in 1 until min((num.length + 1).toDouble(), 19.0).toInt()) {
      if (a + b == num.substring(0, i).toLong()) {
        if (dfs(b, a + b, num.substring(i))) {
          return true
        }
      }
    }
    return false
  }
}
