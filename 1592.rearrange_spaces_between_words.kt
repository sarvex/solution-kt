class Solution {
  fun reorderSpaces(text: String): String {
    var cnt = 0
    for (c in text.toCharArray()) {
      if (c == ' ') {
        ++cnt
      }
    }
    val words = text.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val res: List<String> = ArrayList()
    for (w in words) {
      if ("" != w) {
        res.add(w)
      }
    }
    val m: Int = res.size() - 1
    if (m == 0) {
      return res[0] + " ".repeat(cnt)
    }
    var ans = java.lang.String.join(" ".repeat(cnt / m), res)
    ans += " ".repeat(cnt % m)
    return ans
  }
}
