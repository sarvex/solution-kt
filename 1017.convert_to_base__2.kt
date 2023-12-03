internal class Solution {
  fun baseNeg2(n: Int): String {
    var n = n
    if (n == 0) {
      return "0"
    }
    var k = 1
    val ans = StringBuilder()
    while (n != 0) {
      if (n % 2 != 0) {
        ans.append(1)
        n -= k
      } else {
        ans.append(0)
      }
      k *= -1
      n /= 2
    }
    return ans.reverse().toString()
  }
}
