internal class Solution {
  fun findNthDigit(n: Int): Int {
    var n = n
    var k = 1
    var cnt = 9
    while (k.toLong() * cnt < n) {
      n -= k * cnt
      ++k
      cnt *= 10
    }
    val num = 10.pow((k - 1).toDouble()) as Int + (n - 1) / k
    val idx = (n - 1) % k
    return num.toString()[idx].code - '0'.code
  }
}
