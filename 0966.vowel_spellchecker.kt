import java.util.*

class Solution {
  fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String?> {
    val s: Set<String> = HashSet()
    val low: Map<String, String> = HashMap()
    val pat: Map<String, String> = HashMap()
    for (w in wordlist) {
      s.add(w)
      val t = w.lowercase(Locale.getDefault())
      low.putIfAbsent(t, w)
      pat.putIfAbsent(f(t), w)
    }
    val m = queries.size
    val ans = arrayOfNulls<String>(m)
    for (i in 0 until m) {
      var q = queries[i]
      if (s.contains(q)) {
        ans[i] = q
        continue
      }
      q = q.lowercase(Locale.getDefault())
      if (low.containsKey(q)) {
        ans[i] = low[q]
        continue
      }
      q = f(q)
      if (pat.containsKey(q)) {
        ans[i] = pat[q]
        continue
      }
      ans[i] = ""
    }
    return ans
  }

  private fun f(w: String): String {
    val cs = w.toCharArray()
    for (i in cs.indices) {
      val c = cs[i]
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        cs[i] = '*'
      }
    }
    return String(cs)
  }
}
