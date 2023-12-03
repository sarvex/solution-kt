internal class Solution {
  fun lengthOfLastWord(s: String): Int {
    var i = s.length - 1
    while (i >= 0 && s[i] == ' ') {
      --i
    }
    var j = i
    while (j >= 0 && s[j] != ' ') {
      --j
    }
    return i - j
  }
}
