import kotlin.math.max

internal class Solution {
  fun maxProduct(words: Array<String>): Int {
    val n = words.size
    val mask = IntArray(n)
    var ans = 0
    for (i in 0 until n) {
      for (c in words[i].toCharArray()) {
        mask[i] = mask[i] or (1 shl c.code - 'a'.code)
      }
      for (j in 0 until i) {
        if (mask[i] and mask[j] == 0) {
          ans = max(ans.toDouble(), (words[i].length * words[j].length).toDouble()).toInt()
        }
      }
    }
    return ans
  }
}
