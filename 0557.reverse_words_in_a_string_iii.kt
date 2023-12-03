internal class Solution {
  fun reverseWords(s: String): String {
    val res = StringBuilder()
    for (t in s.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      for (i in t.length - 1 downTo 0) {
        res.append(t[i])
      }
      res.append(" ")
    }
    return res.substring(0, res.length - 1)
  }
}
