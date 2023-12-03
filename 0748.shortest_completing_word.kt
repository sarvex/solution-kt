import java.util.*

internal class Solution {
  fun shortestCompletingWord(licensePlate: String, words: Array<String>): String? {
    val counter = count(licensePlate.lowercase(Locale.getDefault()))
    var ans: String? = null
    var n = 16
    for (word in words) {
      if (n <= word.length) {
        continue
      }
      val t = count(word)
      if (check(counter, t)) {
        n = word.length
        ans = word
      }
    }
    return ans
  }

  private fun count(word: String): IntArray {
    val counter = IntArray(26)
    for (c in word.toCharArray()) {
      if (Character.isLetter(c)) {
        ++counter[c.code - 'a'.code]
      }
    }
    return counter
  }

  private fun check(counter1: IntArray, counter2: IntArray): Boolean {
    for (i in 0..25) {
      if (counter1[i] > counter2[i]) {
        return false
      }
    }
    return true
  }
}
