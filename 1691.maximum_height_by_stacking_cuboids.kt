import kotlin.math.max

class Solution {
  fun maxHeight(cuboids: Array<IntArray>): Int {
    for (c in cuboids) {
      Arrays.sort(c)
    }
    Arrays.sort(
      cuboids
    ) { a, b ->
      if (a.get(0) === b.get(0)) (if (a.get(1) === b.get(1)) a.get(2) - b.get(2) else a.get(1) - b.get(1)) else a.get(
        0
      ) - b.get(0)
    }
    val n = cuboids.size
    val f = IntArray(n)
    for (i in 0 until n) {
      for (j in 0 until i) {
        if (cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
          f[i] = max(f[i].toDouble(), f[j].toDouble()).toInt()
        }
      }
      f[i] += cuboids[i][2]
    }
    return Arrays.stream(f).max().getAsInt()
  }
}
