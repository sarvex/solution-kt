class Solution {
  fun matchReplacement(s: String, sub: String, mappings: Array<CharArray>): Boolean {
    val d: Map<Char, Set<Char>> = HashMap()
    for (e in mappings) {
      d.computeIfAbsent(e[0]) { k -> HashSet() }.add(e[1])
    }
    val m = s.length
    val n = sub.length
    for (i in 0 until m - n + 1) {
      var ok = true
      var j = 0
      while (j < n && ok) {
        val a = s[i + j]
        val b = sub[j]
        if (a != b && !(d[b] ?: Collections.emptySet()).contains(a)) {
          ok = false
        }
        ++j
      }
      if (ok) {
        return true
      }
    }
    return false
  }
}
