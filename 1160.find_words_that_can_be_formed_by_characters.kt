internal class Solution {
  fun countCharacters(words: Array<String>, chars: String): Int {
    val cnt = IntArray(26)
    for (i in 0 until chars.length) {
      ++cnt[chars[i].code - 'a'.code]
    }
    var ans = 0
    for (w in words) {
      val wc = IntArray(26)
      var ok = true
      for (i in 0 until w.length) {
        val j = w[i].code - 'a'.code
        if (++wc[j] > cnt[j]) {
          ok = false
          break
        }
      }
      if (ok) {
        ans += w.length
      }
    }
    return ans
  }
}
