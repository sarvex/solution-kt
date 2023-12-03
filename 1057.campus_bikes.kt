import kotlin.math.abs

internal class Solution {
  fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): IntArray {
    val n = workers.size
    val m = bikes.size
    val arr = Array(m * n) { IntArray(3) }
    var i = 0
    var k = 0
    while (i < n) {
      for (j in 0 until m) {
        val dist =
          (abs((workers[i][0] - bikes[j][0]).toDouble()) + abs((workers[i][1] - bikes[j][1]).toDouble())).toInt()
        arr[k++] = intArrayOf(dist, i, j)
      }
      ++i
    }
    Arrays.sort(arr) { a, b ->
      if (a.get(0) !== b.get(0)) {
        return@sort a.get(0) - b.get(0)
      }
      if (a.get(1) !== b.get(1)) {
        return@sort a.get(1) - b.get(1)
      }
      a.get(2) - b.get(2)
    }
    val vis1 = BooleanArray(n)
    val vis2 = BooleanArray(m)
    val ans = IntArray(n)
    for (e in arr) {
      val i = e[1]
      val j = e[2]
      if (!vis1[i] && !vis2[j]) {
        vis1[i] = true
        vis2[j] = true
        ans[i] = j
      }
    }
    return ans
  }
}
