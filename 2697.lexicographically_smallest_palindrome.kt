class Solution {
  fun makeSmallestPalindrome(s: String): String {
    val cs = s.toCharArray()
    var i = 0
    var j = cs.size - 1
    while (i < j) {
      if (cs[i] != cs[j]) {
        cs[j] = if (cs[i] < cs[j]) cs[i] else cs[j]
        cs[i] = cs[j]
      }
      ++i
      --j
    }
    return String(cs)
  }
}
