internal class Solution {
  fun findSubstring(s: String, words: Array<String>): List<Int> {
    val cnt: Map<String, Int> = HashMap()
    for (w in words) {
      cnt.merge(w, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val m = s.length
    val n = words.size
    val k = words[0].length
    val ans: List<Int> = ArrayList()
    for (i in 0 until k) {
      val cnt1: Map<String, Int> = HashMap()
      var l = i
      var r = i
      var t = 0
      while (r + k <= m) {
        val w = s.substring(r, r + k)
        r += k
        if (!cnt.containsKey(w)) {
          cnt1.clear()
          l = r
          t = 0
          continue
        }
        cnt1.merge(w, 1) { a: Int, b: Int -> Integer.sum(a, b) }
        ++t
        while (cnt1[w]!! > cnt[w]!!) {
          val remove = s.substring(l, l + k)
          l += k
          cnt1.merge(remove, -1) { a: Int, b: Int -> Integer.sum(a, b) }
          --t
        }
        if (t == n) {
          ans.add(l)
        }
      }
    }
    return ans
  }
}
