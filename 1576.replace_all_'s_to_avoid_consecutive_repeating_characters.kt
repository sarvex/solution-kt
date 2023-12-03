class Solution {
  fun modifyString(s: String): String {
    val cs = s.toCharArray()
    val n = cs.size
    for (i in 0 until n) {
      if (cs[i] == '?') {
        var c = 'a'
        while (c <= 'c') {
          if (i > 0 && cs[i - 1] == c || i + 1 < n && cs[i + 1] == c) {
            ++c
            continue
          }
          cs[i] = c
          break
          ++c
        }
      }
    }
    return String(cs)
  }
}
