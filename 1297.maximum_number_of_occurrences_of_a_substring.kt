class Solution {
  fun maxFreq(s: String, maxLetters: Int, minSize: Int, maxSize: Int): Int {
    var ans = 0
    val cnt: Map<String, Int> = HashMap()
    for (i in 0 until s.length - minSize + 1) {
      val t = s.substring(i, i + minSize)
      val ss: Set<Char> = HashSet()
      for (j in 0 until minSize) {
        ss.add(t[j])
      }
      if (ss.size() <= maxLetters) {
        cnt.put(t, (cnt[t] ?: 0) + 1)
        ans = Math.max(ans, cnt[t]!!)
      }
    }
    return ans
  }
}
