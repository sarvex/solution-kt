internal class Solution {
  fun isIsomorphic(s: String, t: String): Boolean {
    val d1 = IntArray(256)
    val d2 = IntArray(256)
    val n = s.length
    for (i in 0 until n) {
      val a = s[i]
      val b = t[i]
      if (d1[a.code] != d2[b.code]) {
        return false
      }
      d1[a.code] = i + 1
      d2[b.code] = i + 1
    }
    return true
  }
}
