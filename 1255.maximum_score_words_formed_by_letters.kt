internal class Solution {
  fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
    val cnt = IntArray(26)
    for (i in letters.indices) {
      cnt[letters[i].code - 'a'.code]++
    }
    val n = words.size
    var ans = 0
    for (i in 0 until (1 shl n)) {
      val cur = IntArray(26)
      for (j in 0 until n) {
        if (i shr j and 1 == 1) {
          for (k in 0 until words[j].length) {
            cur[words[j][k].code - 'a'.code]++
          }
        }
      }
      var ok = true
      var t = 0
      for (j in 0..25) {
        if (cur[j] > cnt[j]) {
          ok = false
          break
        }
        t += cur[j] * score[j]
      }
      if (ok && ans < t) {
        ans = t
      }
    }
    return ans
  }
}
