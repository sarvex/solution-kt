class Solution {
  fun isFascinating(n: Int): Boolean {
    val s = "" + n + 2 * n + 3 * n
    val cnt = IntArray(10)
    for (c in s.toCharArray()) {
      if (++cnt[c.code - '0'.code] > 1) {
        return false
      }
    }
    return cnt[0] == 0 && s.length == 9
  }
}
