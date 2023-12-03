internal class Solution {
  fun hasAlternatingBits(n: Int): Boolean {
    var n = n
    n = n xor (n shr 1)
    return n and n + 1 == 0
  }
}
