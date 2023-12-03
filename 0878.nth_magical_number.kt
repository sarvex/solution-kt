internal class Solution {
  fun nthMagicalNumber(n: Int, a: Int, b: Int): Int {
    val c = a * b / gcd(a, b)
    var l: Long = 0
    var r = (a + b).toLong() * n
    while (l < r) {
      val mid = l + r ushr 1
      if (mid / a + mid / b - mid / c >= n) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return (l % Solution.Companion.MOD).toInt()
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
