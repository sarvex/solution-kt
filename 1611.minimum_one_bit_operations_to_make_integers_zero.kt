class Solution {
  fun minimumOneBitOperations(n: Int): Int {
    var n = n
    var ans = 0
    while (n > 0) {
      ans = ans xor n
      n = n shr 1
    }
    return ans
  }
}
