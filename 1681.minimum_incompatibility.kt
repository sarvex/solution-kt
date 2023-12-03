import kotlin.math.max
import kotlin.math.min

class Solution {
  fun minimumIncompatibility(nums: IntArray, k: Int): Int {
    val n = nums.size
    val m = n / k
    val g = IntArray(1 shl n)
    Arrays.fill(g, -1)
    for (i in 1 until (1 shl n)) {
      if (Integer.bitCount(i) != m) {
        continue
      }
      val s: Set<Int> = HashSet()
      var mi = 20
      var mx = 0
      for (j in 0 until n) {
        if (i shr j and 1 == 1) {
          if (!s.add(nums[j])) {
            break
          }
          mi = min(mi.toDouble(), nums[j].toDouble()).toInt()
          mx = max(mx.toDouble(), nums[j].toDouble()).toInt()
        }
      }
      if (s.size() === m) {
        g[i] = mx - mi
      }
    }
    val f = IntArray(1 shl n)
    val inf = 1 shl 30
    Arrays.fill(f, inf)
    f[0] = 0
    for (i in 0 until (1 shl n)) {
      if (f[i] == inf) {
        continue
      }
      val s: Set<Int> = HashSet()
      var mask = 0
      for (j in 0 until n) {
        if (i shr j and 1 == 0 && !s.contains(nums[j])) {
          s.add(nums[j])
          mask = mask or (1 shl j)
        }
      }
      if (s.size() < m) {
        continue
      }
      var j = mask
      while (j > 0) {
        if (g[j] != -1) {
          f[i or j] = min(f[i or j].toDouble(), (f[i] + g[j]).toDouble()).toInt()
        }
        j = j - 1 and mask
      }
    }
    return if (f[(1 shl n) - 1] == inf) -1 else f[(1 shl n) - 1]
  }
}
