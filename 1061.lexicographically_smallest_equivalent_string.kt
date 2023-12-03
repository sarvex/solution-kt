internal class Solution {
  private var p: IntArray
  fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
    p = IntArray(26)
    for (i in 0..25) {
      p[i] = i
    }
    for (i in 0 until s1.length) {
      val a = s1[i].code - 'a'.code
      val b = s2[i].code - 'a'.code
      val pa = find(a)
      val pb = find(b)
      if (pa < pb) {
        p[pb] = pa
      } else {
        p[pa] = pb
      }
    }
    val sb = StringBuilder()
    for (a in baseStr.toCharArray()) {
      val b = (find(a.code - 'a'.code) + 'a'.code).toChar()
      sb.append(b)
    }
    return sb.toString()
  }

  private fun find(x: Int): Int {
    if (p[x] != x) {
      p[x] = find(p[x])
    }
    return p[x]
  }
}
