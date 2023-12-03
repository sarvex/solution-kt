import kotlin.math.min

class BinaryIndexedTree(private val n: Int) {
  private val inf = 1 shl 30
  private val c: IntArray

  init {
    c = IntArray(n + 1)
    Arrays.fill(c, inf)
  }

  fun update(x: Int, v: Int) {
    var x = x
    while (x <= n) {
      c[x] = min(c[x].toDouble(), v.toDouble()).toInt()
      x += x and -x
    }
  }

  fun query(x: Int): Int {
    var x = x
    var mi = inf
    while (x > 0) {
      mi = min(mi.toDouble(), c[x].toDouble()).toInt()
      x -= x and -x
    }
    return if (mi == inf) -1 else mi
  }
}

internal class Solution {
  fun leftmostBuildingQueries(heights: IntArray, queries: Array<IntArray>): IntArray {
    val n = heights.size
    val m = queries.size
    for (i in 0 until m) {
      if (queries[i][0] > queries[i][1]) {
        queries[i] = intArrayOf(queries[i][1], queries[i][0])
      }
    }
    val idx = arrayOfNulls<Int>(m)
    for (i in 0 until m) {
      idx[i] = i
    }
    Arrays.sort(idx) { i, j -> queries[j][1] - queries[i][1] }
    val s = heights.clone()
    Arrays.sort(s)
    val ans = IntArray(m)
    var j = n - 1
    val tree = BinaryIndexedTree(n)
    for (i in idx) {
      val l = queries[i][0]
      val r = queries[i][1]
      while (j > r) {
        val k: Int = n - Arrays.binarySearch(s, heights[j]) + 1
        tree.update(k, j)
        --j
      }
      if (l == r || heights[l] < heights[r]) {
        ans[i] = r
      } else {
        val k: Int = n - Arrays.binarySearch(s, heights[l])
        ans[i] = tree.query(k)
      }
    }
    return ans
  }
}
