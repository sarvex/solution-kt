internal class Solution {
  fun customSortString(order: String, s: String): String {
    val cnt = IntArray(26)
    for (i in 0 until s.length) {
      ++cnt[s[i].code - 'a'.code]
    }
    val ans = StringBuilder()
    for (i in 0 until order.length) {
      val c = order[i]
      while (cnt[c.code - 'a'.code]-- > 0) {
        ans.append(c)
      }
    }
    for (i in 0..25) {
      while (cnt[i]-- > 0) {
        ans.append(('a'.code + i).toChar())
      }
    }
    return ans.toString()
  }
}
