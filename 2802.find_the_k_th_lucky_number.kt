class Solution {
  fun kthLuckyNumber(k: Int): String {
    var k = k
    var n = 1
    while (k > 1 shl n) {
      k -= 1 shl n
      ++n
    }
    val ans = StringBuilder()
    while (n-- > 0) {
      if (k <= 1 shl n) {
        ans.append('4')
      } else {
        ans.append('7')
        k -= 1 shl n
      }
    }
    return ans.toString()
  }
}
