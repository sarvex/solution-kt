import kotlin.math.abs

class Solution {
  private val points: List<IntArray> = ArrayList()
  fun beautifulPair(nums1: IntArray, nums2: IntArray): IntArray {
    val n = nums1.size
    val pl: Map<Long, List<Int>> = HashMap()
    for (i in 0 until n) {
      val z = f(nums1[i], nums2[i])
      pl.computeIfAbsent(z) { k -> ArrayList() }.add(i)
    }
    for (i in 0 until n) {
      val z = f(nums1[i], nums2[i])
      if (pl[z]!!.size() > 1) {
        return intArrayOf(i, pl[z]!![1])
      }
      points.add(intArrayOf(nums1[i], nums2[i], i))
    }
    points.sort { a, b -> a.get(0) - b.get(0) }
    val ans = dfs(0, points.size() - 1)
    return intArrayOf(ans[1], ans[2])
  }

  private fun f(x: Int, y: Int): Long {
    return x * 100000L + y
  }

  private fun dist(x1: Int, y1: Int, x2: Int, y2: Int): Int {
    return (abs((x1 - x2).toDouble()) + abs((y1 - y2).toDouble())).toInt()
  }

  private fun dfs(l: Int, r: Int): IntArray {
    if (l >= r) {
      return intArrayOf(1 shl 30, -1, -1)
    }
    val m = l + r shr 1
    val x = points[m][0]
    var t1 = dfs(l, m)
    val t2 = dfs(m + 1, r)
    if (t1[0] > t2[0] || t1[0] == t2[0] && (t1[1] > t2[1] || t1[1] == t2[1] && t1[2] > t2[2])) {
      t1 = t2
    }
    val t: List<IntArray> = ArrayList()
    for (i in l..r) {
      if (Math.abs(points[i][0] - x) <= t1[0]) {
        t.add(points[i])
      }
    }
    t.sort { a, b -> a.get(1) - b.get(1) }
    for (i in 0 until t.size()) {
      for (j in i + 1 until t.size()) {
        if (t[j][1] - t[i][1] > t1[0]) {
          break
        }
        val pi = Math.min(t[i][2], t[j][2])
        val pj = Math.max(t[i][2], t[j][2])
        val d = dist(t[i][0], t[i][1], t[j][0], t[j][1])
        if (d < t1[0] || d == t1[0] && (pi < t1[1] || pi == t1[1] && pj < t1[2])) {
          t1 = intArrayOf(d, pi, pj)
        }
      }
    }
    return t1
  }
}
