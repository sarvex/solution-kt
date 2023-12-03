import kotlin.math.abs
import kotlin.math.min

internal class Solution {
  fun findRotateSteps(ring: String, key: String): Int {
    val m = key.length
    val n = ring.length
    val pos: Array<List<Int>?> = arrayOfNulls(26)
    Arrays.setAll(pos) { k -> ArrayList() }
    for (i in 0 until n) {
      val j = ring[i].code - 'a'.code
      pos[j].add(i)
    }
    val f = Array(m) { IntArray(n) }
    for (g in f) {
      Arrays.fill(g, 1 shl 30)
    }
    for (j in pos[key[0].code - 'a'.code]!!) {
      f[0][j] = (min(j.toDouble(), (n - j).toDouble()) + 1).toInt()
    }
    for (i in 1 until m) {
      for (j in pos[key[i].code - 'a'.code]!!) {
        for (k in pos[key[i - 1].code - 'a'.code]!!) {
          f[i][j] = min(
            f[i][j].toDouble(),
            (f[i - 1][k] + min(abs((j - k).toDouble()), (n - abs((j - k).toDouble())).toDouble()) + 1).toDouble()
          )
            .toInt()
        }
      }
    }
    var ans = 1 shl 30
    for (j in pos[key[m - 1].code - 'a'.code]!!) {
      ans = min(ans.toDouble(), f[m - 1][j].toDouble()).toInt()
    }
    return ans
  }
}
