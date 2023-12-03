class Solution {
  fun sumZero(n: Int): IntArray {
    val ans = IntArray(n)
    for (i in 1 until n) {
      ans[i] = i
    }
    ans[0] = -(n * (n - 1) / 2)
    return ans
  }
}
