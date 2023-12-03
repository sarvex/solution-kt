internal class Solution {
  fun groupStrings(strings: Array<String>): List<List<String>> {
    val mp: Map<String, List<String>> = HashMap()
    for (s in strings) {
      val diff = s[0].code - 'a'.code
      val t = s.toCharArray()
      for (i in t.indices) {
        var d = (t[i].code - diff).toChar()
        if (d < 'a') {
          d += 26.toChar().code
        }
        t[i] = d
      }
      val key = String(t)
      mp.computeIfAbsent(key) { k -> ArrayList() }.add(s)
    }
    return ArrayList(mp.values())
  }
}
