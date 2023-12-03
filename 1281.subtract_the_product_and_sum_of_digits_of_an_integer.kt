class Solution {
  fun subtractProductAndSum(n: Int): Int {
    var n = n
    var x = 1
    var y = 0
    while (n > 0) {
      val v = n % 10
      x *= v
      y += v
      n /= 10
    }
    return x - y
  }
}
