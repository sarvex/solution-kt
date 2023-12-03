class Solution {
  fun firstPalindrome(words: Array<String>): String {
    for (w in words) {
      var ok = true
      var i = 0
      var j = w.length - 1
      while (i < j && ok) {
        if (w[i] != w[j]) {
          ok = false
        }
        ++i
        --j
      }
      if (ok) {
        return w
      }
    }
    return ""
  }
}
