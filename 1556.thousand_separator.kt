class Solution {
  fun thousandSeparator(n: Int): String {
    var n = n
    var cnt = 0
    val ans = StringBuilder()
    while (true) {
      val v = n % 10
      n /= 10
      ans.append(v)
      ++cnt
      if (n == 0) {
        break
      }
      if (cnt == 3) {
        ans.append('.')
        cnt = 0
      }
    }
    return ans.reverse().toString()
  }
}
