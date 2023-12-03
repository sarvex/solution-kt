internal class Solution {
  fun wordPattern(pattern: String, s: String): Boolean {
    val ws = s.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    if (pattern.length != ws.size) {
      return false
    }
    val d1: Map<Char, String> = HashMap()
    val d2: Map<String, Char> = HashMap()
    for (i in ws.indices) {
      val a = pattern[i]
      val b = ws[i]
      if (!(d1[a] ?: b).equals(b) || d2[b] ?: a !== a) {
        return false
      }
      d1.put(a, b)
      d2.put(b, a)
    }
    return true
  }
}
