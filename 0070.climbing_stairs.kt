internal class Solution {
  fun climbStairs(n: Int): Int {
    var a = 0
    var b = 1
    for (i in 0 until n) {
      val c = a + b
      a = b
      b = c
    }
    return b
  }
}
