import kotlin.math.max
import kotlin.math.min

class Solution {
  fun minSpaceWastedKResizing(nums: IntArray, k: Int): Int {
    var k = k
    ++k
    val n = nums.size
    val g = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      var s = 0
      var mx = 0
      for (j in i until n) {
        s += nums[j]
        mx = max(mx.toDouble(), nums[j].toDouble()).toInt()
        g[i][j] = mx * (j - i + 1) - s
      }
    }
    val f = Array(n + 1) { IntArray(k + 1) }
    val inf = 0x3f3f3f3f
    for (i in f.indices) {
      Arrays.fill(f[i], inf)
    }
    f[0][0] = 0
    for (i in 1..n) {
      for (j in 1..k) {
        for (h in 0 until i) {
          f[i][j] = min(f[i][j].toDouble(), (f[h][j - 1] + g[h][i - 1]).toDouble())
            .toInt()
        }
      }
    }
    return f[n][k]
  }
}
