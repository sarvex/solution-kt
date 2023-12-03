import kotlin.math.max

internal class Solution {
  fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
    val cnt = IntArray(26)
    for (b in words2) {
      val t = IntArray(26)
      for (i in 0 until b.length) {
        t[b[i].code - 'a'.code]++
      }
      for (i in 0..25) {
        cnt[i] = max(cnt[i].toDouble(), t[i].toDouble()).toInt()
      }
    }
    val ans: List<String> = ArrayList()
    for (a in words1) {
      val t = IntArray(26)
      for (i in 0 until a.length) {
        t[a[i].code - 'a'.code]++
      }
      var ok = true
      for (i in 0..25) {
        if (cnt[i] > t[i]) {
          ok = false
          break
        }
      }
      if (ok) {
        ans.add(a)
      }
    }
    return ans
  }
}
