class Solution {
  fun divisibilityArray(word: String, m: Int): IntArray {
    val n = word.length
    val ans = IntArray(n)
    var x: Long = 0
    for (i in 0 until n) {
      x = (x * 10 + word[i].code.toLong() - '0'.code.toLong()) % m
      if (x == 0L) {
        ans[i] = 1
      }
    }
    return ans
  }
}
