class Solution {
  fun oddString(words: Array<String>): String {
    val d = HashMap<String, List<String>>()
    for (s in words) {
      val m = s.length
      val cs = CharArray(m - 1)
      for (i in 0 until m - 1) {
        cs[i] = (s[i + 1].code - s[i].code).toChar()
      }
      val t = String(cs)
      d.putIfAbsent(t, ArrayList())
      d[t].add(s)
    }
    for (ss in d.values()) {
      if (ss.size() === 1) {
        return ss.get(0)
      }
    }
    return ""
  }
}
