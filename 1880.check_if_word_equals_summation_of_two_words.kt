class Solution {
  fun isSumEqual(firstWord: String, secondWord: String, targetWord: String): Boolean {
    return f(firstWord) + f(secondWord) == f(targetWord)
  }

  private fun f(s: String): Int {
    var res = 0
    for (c in s.toCharArray()) {
      res = res * 10 + (c.code - 'a'.code)
    }
    return res
  }
}
