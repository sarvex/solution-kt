class Solution {
  fun minimizedStringLength(s: String): Int {
    val ss: Set<Char> = HashSet()
    for (i in 0 until s.length) {
      ss.add(s[i])
    }
    return ss.size()
  }
}
