import kotlin.math.min

class Solution {
  fun findRLEArray(encoded1: Array<IntArray>, encoded2: Array<IntArray>): List<List<Int>> {
    val ans: List<List<Int>> = ArrayList()
    var j = 0
    for (e in encoded1) {
      val vi = e[0]
      var fi = e[1]
      while (fi > 0) {
        val f = min(fi.toDouble(), encoded2[j][1].toDouble()).toInt()
        val v = vi * encoded2[j][0]
        val m: Int = ans.size()
        if (m > 0 && ans[m - 1][0] === v) {
          ans[m - 1].set(1, ans[m - 1][1] + f)
        } else {
          ans.add(ArrayList(List.of(v, f)))
        }
        fi -= f
        encoded2[j][1] -= f
        if (encoded2[j][1] == 0) {
          ++j
        }
      }
    }
    return ans
  }
}
