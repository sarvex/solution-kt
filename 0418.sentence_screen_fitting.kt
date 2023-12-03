internal class Solution {
  fun wordsTyping(sentence: Array<String?>, rows: Int, cols: Int): Int {
    var rows = rows
    val s = java.lang.String.join(" ", *sentence) + " "
    val m = s.length
    var cur = 0
    while (rows-- > 0) {
      cur += cols
      if (s[cur % m] == ' ') {
        ++cur
      } else {
        while (cur > 0 && s[(cur - 1) % m] != ' ') {
          --cur
        }
      }
    }
    return cur / m
  }
}
