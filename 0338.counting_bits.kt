internal class Solution {
  fun countBits(n: Int): IntArray {
    val ans = IntArray(n + 1)
    for (i in 1..n) {
      ans[i] = ans[i and i - 1] + 1
    }
    return ans
  }
}
