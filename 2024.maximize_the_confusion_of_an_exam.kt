import kotlin.math.max

class Solution {
  fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
    return max(get('T', k, answerKey).toDouble(), get('F', k, answerKey).toDouble()).toInt()
  }

  operator fun get(c: Char, k: Int, answerKey: String): Int {
    var k = k
    var l = 0
    var r = 0
    while (r < answerKey.length) {
      if (answerKey[r++] == c) {
        --k
      }
      if (k < 0 && answerKey[l++] == c) {
        ++k
      }
    }
    return r - l
  }
}
