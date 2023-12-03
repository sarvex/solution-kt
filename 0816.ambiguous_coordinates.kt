internal class Solution {
  fun ambiguousCoordinates(s: String): List<String> {
    val n = s.length
    val ans: List<String> = ArrayList()
    for (i in 2 until n - 1) {
      for (x in f(s, 1, i)) {
        for (y in f(s, i, n - 1)) {
          ans.add(String.format("(%s, %s)", x, y))
        }
      }
    }
    return ans
  }

  private fun f(s: String, i: Int, j: Int): List<String> {
    val res: List<String> = ArrayList()
    for (k in 1..j - i) {
      val l = s.substring(i, i + k)
      val r = s.substring(i + k, j)
      val ok = ("0" == l || !l.startsWith("0")) && !r.endsWith("0")
      if (ok) {
        res.add(l + (if (k < j - i) "." else "") + r)
      }
    }
    return res
  }
}
