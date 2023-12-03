internal class Solution {
  fun subdomainVisits(cpdomains: Array<String>): List<String> {
    val cnt: Map<String, Int> = HashMap()
    for (s in cpdomains) {
      var i = s.indexOf(" ")
      val v = s.substring(0, i).toInt()
      while (i < s.length) {
        if (s[i] == ' ' || s[i] == '.') {
          val t = s.substring(i + 1)
          cnt.put(t, (cnt[t] ?: 0) + v)
        }
        ++i
      }
    }
    val ans: List<String> = ArrayList()
    for (e in cnt.entrySet()) {
      ans.add(e.getValue() + " " + e.getKey())
    }
    return ans
  }
}
