internal class Solution {
  fun repeatedStringMatch(a: String, b: String): Int {
    val m = a.length
    val n = b.length
    var ans = (n + m - 1) / m
    val t = StringBuilder(a.repeat(ans))
    for (i in 0..2) {
      if (t.toString().contains(b)) {
        return ans
      }
      ++ans
      t.append(a)
    }
    return -1
  }
}
