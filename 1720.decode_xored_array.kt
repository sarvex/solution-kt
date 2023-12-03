class Solution {
  fun decode(encoded: IntArray, first: Int): IntArray {
    val n = encoded.size
    val ans = IntArray(n + 1)
    ans[0] = first
    for (i in 0 until n) {
      ans[i + 1] = ans[i] xor encoded[i]
    }
    return ans
  }
}
