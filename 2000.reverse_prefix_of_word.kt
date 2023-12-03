class Solution {
  fun reversePrefix(word: String, ch: Char): String {
    var j = word.indexOf(ch)
    if (j == -1) {
      return word
    }
    val cs = word.toCharArray()
    var i = 0
    while (i < j) {
      val t = cs[i]
      cs[i] = cs[j]
      cs[j] = t
      ++i
      --j
    }
    return String(cs)
  }
}
