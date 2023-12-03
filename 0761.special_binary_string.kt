internal class Solution {
  fun makeLargestSpecial(s: String): String {
    if ("" == s) {
      return ""
    }
    val ans: List<String> = ArrayList()
    var cnt = 0
    var i = 0
    var j = 0
    while (i < s.length) {
      cnt += if (s[i] == '1') 1 else -1
      if (cnt == 0) {
        val t = "1" + makeLargestSpecial(s.substring(j + 1, i)) + "0"
        ans.add(t)
        j = i + 1
      }
      ++i
    }
    ans.sort(Comparator.reverseOrder())
    return java.lang.String.join("", ans)
  }
}
