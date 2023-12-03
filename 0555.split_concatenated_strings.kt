internal class Solution {
  fun splitLoopedString(strs: Array<String>): String {
    val n = strs.size
    for (i in 0 until n) {
      val s = strs[i]
      val t = StringBuilder(s).reverse().toString()
      if (s.compareTo(t) < 0) {
        strs[i] = t
      }
    }
    var ans = ""
    for (i in 0 until n) {
      val s = strs[i]
      val sb = StringBuilder()
      for (j in i + 1 until n) {
        sb.append(strs[j])
      }
      for (j in 0 until i) {
        sb.append(strs[j])
      }
      val t = sb.toString()
      for (j in 0 until s.length) {
        val a = s.substring(j)
        val b = s.substring(0, j)
        var cur = a + t + b
        if (ans.compareTo(cur) < 0) {
          ans = cur
        }
        cur = StringBuilder(b)
          .reverse()
          .append(t)
          .append(StringBuilder(a).reverse().toString())
          .toString()
        if (ans.compareTo(cur) < 0) {
          ans = cur
        }
      }
    }
    return ans
  }
}
