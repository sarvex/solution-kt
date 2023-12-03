internal class Solution {
  fun isOneBitCharacter(bits: IntArray): Boolean {
    var i = 0
    val n = bits.size
    while (i < n - 1) {
      i += bits[i] + 1
    }
    return i == n - 1
  }
}
