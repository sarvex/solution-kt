internal class Solution {
  fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
    val m = rolls.size
    var s = (n + m) * mean
    for (v in rolls) {
      s -= v
    }
    if (s > n * 6 || s < n) {
      return IntArray(0)
    }
    val ans = IntArray(n)
    Arrays.fill(ans, s / n)
    for (i in 0 until s % n) {
      ++ans[i]
    }
    return ans
  }
}
