internal class Solution {
  fun frequencySort(s: String): String {
    val cnt: Map<Char, Int> = HashMap(52)
    for (i in 0 until s.length) {
      cnt.merge(s[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val cs: List<Char> = ArrayList(cnt.keySet())
    cs.sort { a, b -> cnt[b]!! - cnt[a]!! }
    val ans = StringBuilder()
    for (c in cs) {
      for (v in cnt[c]!! downTo 1) {
        ans.append(c)
      }
    }
    return ans.toString()
  }
}
