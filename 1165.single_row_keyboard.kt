import kotlin.math.abs

internal class Solution {
  fun calculateTime(keyboard: String, word: String): Int {
    val pos = IntArray(26)
    for (i in 0..25) {
      pos[keyboard[i].code - 'a'.code] = i
    }
    var ans = 0
    var i = 0
    for (k in 0 until word.length) {
      val j = pos[word[k].code - 'a'.code]
      (ans += abs((i - j).toDouble())).toInt()
      i = j
    }
    return ans
  }
}
