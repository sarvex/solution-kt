class Solution {
  fun evenOddBit(n: Int): IntArray {
    var n = n
    val ans = IntArray(2)
    var i = 0
    while (n > 0) {
      ans[i] += n and 1
      n = n shr 1
      i = i xor 1
    }
    return ans
  }
}
