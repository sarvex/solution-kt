import kotlin.math.min

internal class Solution {
  fun getHint(secret: String, guess: String): String {
    var x = 0
    var y = 0
    val cnt1 = IntArray(10)
    val cnt2 = IntArray(10)
    for (i in 0 until secret.length) {
      val a = secret[i].code - '0'.code
      val b = guess[i].code - '0'.code
      if (a == b) {
        ++x
      } else {
        ++cnt1[a]
        ++cnt2[b]
      }
    }
    for (i in 0..9) {
      (y += min(cnt1[i].toDouble(), cnt2[i].toDouble())).toInt()
    }
    return String.format("%dA%dB", x, y)
  }
}
