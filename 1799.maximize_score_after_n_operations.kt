import kotlin.math.max

class Solution {
  fun maxScore(nums: IntArray): Int {
    val m = nums.size
    val g = Array(m) { IntArray(m) }
    for (i in 0 until m) {
      for (j in i + 1 until m) {
        g[i][j] = gcd(nums[i], nums[j])
      }
    }
    val f = IntArray(1 shl m)
    for (k in 0 until (1 shl m)) {
      val cnt = Integer.bitCount(k)
      if (cnt % 2 == 0) {
        for (i in 0 until m) {
          if (k shr i and 1 == 1) {
            for (j in i + 1 until m) {
              if (k shr j and 1 == 1) {
                f[k] = max(
                  f[k].toDouble(), (f[k xor (1 shl i) xor (1 shl j)] + cnt / 2 * g[i][j]).toDouble()
                ).toInt()
              }
            }
          }
        }
      }
    }
    return f[(1 shl m) - 1]
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
