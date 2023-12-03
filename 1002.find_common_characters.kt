import kotlin.math.min

internal class Solution {
  fun commonChars(words: Array<String>): List<String> {
    val cnt = IntArray(26)
    Arrays.fill(cnt, 10000)
    for (w in words) {
      val ccnt = IntArray(26)
      for (i in 0 until w.length) {
        ++ccnt[w[i].code - 'a'.code]
      }
      for (i in 0..25) {
        cnt[i] = min(cnt[i].toDouble(), ccnt[i].toDouble()).toInt()
      }
    }
    val ans: List<String> = ArrayList()
    for (i in 0..25) {
      while (cnt[i]-- > 0) {
        ans.add((i + 'a'.code).toChar().toString())
      }
    }
    return ans
  }
}
