internal class Solution {
  fun countVowels(word: String): Long {
    var ans: Long = 0
    var i = 0
    val n = word.length
    while (i < n) {
      val c = word[i]
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        ans += (i + 1L) * (n - i)
      }
      ++i
    }
    return ans
  }
}
