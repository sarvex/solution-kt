import java.util.*

internal class Solution {
  fun findWords(words: Array<String>): Array<String> {
    val s = "12210111011122000010020202"
    val ans: List<String> = ArrayList()
    for (w in words) {
      val t = w.lowercase(Locale.getDefault())
      val x = s[t[0].code - 'a'.code]
      var ok = true
      for (c in t.toCharArray()) {
        if (s[c.code - 'a'.code] != x) {
          ok = false
          break
        }
      }
      if (ok) {
        ans.add(w)
      }
    }
    return ans.toArray(arrayOfNulls<String>(0))
  }
}
