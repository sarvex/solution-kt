class Solution {
  fun smallestBeautifulString(s: String, k: Int): String {
    val n = s.length
    val cs = s.toCharArray()
    for (i in n - 1 downTo 0) {
      val p = cs[i].code - 'a'.code + 1
      for (j in p until k) {
        var c = ('a'.code + j).toChar()
        if (i > 0 && cs[i - 1] == c || i > 1 && cs[i - 2] == c) {
          continue
        }
        cs[i] = c
        for (l in i + 1 until n) {
          for (m in 0 until k) {
            c = ('a'.code + m).toChar()
            if (l > 0 && cs[l - 1] == c || l > 1 && cs[l - 2] == c) {
              continue
            }
            cs[l] = c
            break
          }
        }
        return String(cs)
      }
    }
    return ""
  }
}
