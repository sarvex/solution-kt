class Solution {
  fun areAlmostEqual(s1: String, s2: String): Boolean {
    var cnt = 0
    var c1 = 0.toChar()
    var c2 = 0.toChar()
    for (i in 0 until s1.length) {
      val a = s1[i]
      val b = s2[i]
      if (a != b) {
        if (++cnt > 2 || cnt == 2 && (a != c2 || b != c1)) {
          return false
        }
        c1 = a
        c2 = b
      }
    }
    return cnt != 1
  }
}
