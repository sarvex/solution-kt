internal class Solution {
  fun countAndSay(n: Int): String {
    var n = n
    var s = "1"
    while (--n > 0) {
      val t = StringBuilder()
      var i = 0
      while (i < s.length) {
        var j = i
        while (j < s.length && s[j] == s[i]) {
          ++j
        }
        t.append((j - i).toString() + "")
        t.append(s[i])
        i = j
      }
      s = t.toString()
    }
    return s
  }
}
