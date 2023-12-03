import kotlin.math.max

internal class Solution {
  fun maximumGood(statements: Array<IntArray>): Int {
    var ans = 0
    for (mask in 1 until (1 shl statements.size)) {
      ans = max(ans.toDouble(), check(mask, statements).toDouble()).toInt()
    }
    return ans
  }

  private fun check(mask: Int, statements: Array<IntArray>): Int {
    var cnt = 0
    val n = statements.size
    for (i in 0 until n) {
      if (mask shr i and 1 == 1) {
        for (j in 0 until n) {
          val v = statements[i][j]
          if (v < 2 && mask shr j and 1 != v) {
            return 0
          }
        }
        ++cnt
      }
    }
    return cnt
  }
}
