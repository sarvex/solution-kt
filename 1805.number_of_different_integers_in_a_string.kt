class Solution {
  fun numDifferentIntegers(word: String): Int {
    val s: Set<String> = HashSet()
    val n = word.length
    var i = 0
    while (i < n) {
      if (Character.isDigit(word[i])) {
        while (i < n && word[i] == '0') {
          ++i
        }
        var j = i
        while (j < n && Character.isDigit(word[j])) {
          ++j
        }
        s.add(word.substring(i, j))
        i = j
      }
      ++i
    }
    return s.size()
  }
}
