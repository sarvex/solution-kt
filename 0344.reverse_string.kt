internal class Solution {
  fun reverseString(s: CharArray) {
    var i = 0
    var j = s.size - 1
    while (i < j) {
      val t = s[i]
      s[i] = s[j]
      s[j] = t
      ++i
      --j
    }
  }
}
