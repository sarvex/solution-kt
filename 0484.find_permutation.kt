import kotlin.math.max

internal class Solution {
  fun findPermutation(s: String): IntArray {
    val n = s.length
    val ans = IntArray(n + 1)
    for (i in 0 until n + 1) {
      ans[i] = i + 1
    }
    var i = 0
    while (i < n) {
      var j = i
      while (j < n && s[j] == 'D') {
        ++j
      }
      reverse(ans, i, j)
      i = max((i + 1).toDouble(), j.toDouble()).toInt()
    }
    return ans
  }

  private fun reverse(arr: IntArray, i: Int, j: Int) {
    var i = i
    var j = j
    while (i < j) {
      val t = arr[i]
      arr[i] = arr[j]
      arr[j] = t
      ++i
      --j
    }
  }
}
