class Solution {
  fun distinctNames(ideas: Array<String>): Long {
    val s: Set<String> = HashSet()
    for (v in ideas) {
      s.add(v)
    }
    val f = Array(26) { IntArray(26) }
    for (v in ideas) {
      val t = v.toCharArray()
      val i = t[0].code - 'a'.code
      for (j in 0..25) {
        t[0] = (j + 'a'.code).toChar()
        if (!s.contains(String(t))) {
          ++f[i][j]
        }
      }
    }
    var ans: Long = 0
    for (v in ideas) {
      val t = v.toCharArray()
      val i = t[0].code - 'a'.code
      for (j in 0..25) {
        t[0] = (j + 'a'.code).toChar()
        if (!s.contains(String(t))) {
          ans += f[j][i].toLong()
        }
      }
    }
    return ans
  }
}
