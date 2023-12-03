import kotlin.math.min

internal class Solution {
  fun maxNumberOfBalloons(text: String): Int {
    val cnt = IntArray(26)
    for (i in 0 until text.length) {
      ++cnt[text[i].code - 'a'.code]
    }
    cnt['l'.code - 'a'.code] = cnt['l'.code - 'a'.code] shr 1
    cnt['o'.code - 'a'.code] = cnt['o'.code - 'a'.code] shr 1
    var ans = 1 shl 30
    for (c in "balon".toCharArray()) {
      ans = min(ans.toDouble(), cnt[c.code - 'a'.code].toDouble()).toInt()
    }
    return ans
  }
}
