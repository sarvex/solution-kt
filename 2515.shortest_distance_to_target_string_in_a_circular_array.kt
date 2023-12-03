import kotlin.math.abs
import kotlin.math.min

class Solution {
  fun closetTarget(words: Array<String>, target: String, startIndex: Int): Int {
    val n = words.size
    var ans = n
    for (i in 0 until n) {
      val w = words[i]
      if (w == target) {
        val t = abs((i - startIndex).toDouble()).toInt()
        ans = min(ans.toDouble(), min(t.toDouble(), (n - t).toDouble())).toInt()
      }
    }
    return if (ans == n) -1 else ans
  }
}
