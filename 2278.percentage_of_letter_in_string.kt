class Solution {
  fun percentageLetter(s: String, letter: Char): Int {
    var cnt = 0
    for (c in s.toCharArray()) {
      if (c == letter) {
        ++cnt
      }
    }
    return cnt * 100 / s.length
  }
}
