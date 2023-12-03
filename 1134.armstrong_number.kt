internal class Solution {
  fun isArmstrong(n: Int): Boolean {
    val k = (n.toString() + "").length
    var s = 0
    var x = n
    while (x > 0) {
      s += (x % 10).pow(k.toDouble())
      x /= 10
    }
    return s == n
  }
}
