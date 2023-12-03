internal class Solution {
  fun toLowerCase(s: String): String {
    val cs = s.toCharArray()
    for (i in cs.indices) {
      if (cs[i] >= 'A' && cs[i] <= 'Z') {
        cs[i] = (cs[i].code or 32).toChar()
      }
    }
    return String(cs)
  }
}
