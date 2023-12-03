import kotlin.math.max
import kotlin.math.min

class Solution {
  fun countPairs(n: Int, edges: Array<IntArray>, queries: IntArray): IntArray {
    val cnt = IntArray(n)
    val g: Map<Int, Int> = HashMap()
    for (e in edges) {
      val a = e[0] - 1
      val b = e[1] - 1
      ++cnt[a]
      ++cnt[b]
      val k = (min(a.toDouble(), b.toDouble()) * n + max(a.toDouble(), b.toDouble())).toInt()
      g.merge(k, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val s = cnt.clone()
    Arrays.sort(s)
    val ans = IntArray(queries.size)
    for (i in queries.indices) {
      val t = queries[i]
      for (j in 0 until n) {
        val x = s[j]
        val k = search(s, t - x, j + 1)
        ans[i] += n - k
      }
      for (e in g.entrySet()) {
        val a: Int = e.getKey() / n
        val b: Int = e.getKey() % n
        val v: Int = e.getValue()
        if (cnt[a] + cnt[b] > t && cnt[a] + cnt[b] - v <= t) {
          --ans[i]
        }
      }
    }
    return ans
  }

  private fun search(arr: IntArray, x: Int, i: Int): Int {
    var left = i
    var right = arr.size
    while (left < right) {
      val mid = left + right shr 1
      if (arr[mid] > x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
