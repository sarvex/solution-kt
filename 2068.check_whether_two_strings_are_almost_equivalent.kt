import kotlin.math.abs

internal class Solution {
  fun checkAlmostEquivalent(word1: String, word2: String): Boolean {
    val cnt = IntArray(26)
    for (i in 0 until word1.length) {
      ++cnt[word1[i].code - 'a'.code]
    }
    for (i in 0 until word2.length) {
      --cnt[word2[i].code - 'a'.code]
    }
    for (x in cnt) {
      if (abs(x.toDouble()) > 3) {
        return false
      }
    }
    return true
  }
}
