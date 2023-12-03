class Solution {
  fun canBeTypedWords(text: String, brokenLetters: String): Int {
    val s = BooleanArray(26)
    for (c in brokenLetters.toCharArray()) {
      s[c.code - 'a'.code] = true
    }
    var ans = 0
    for (w in text.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      for (c in w.toCharArray()) {
        if (s[c.code - 'a'.code]) {
          --ans
          break
        }
      }
      ++ans
    }
    return ans
  }
}
