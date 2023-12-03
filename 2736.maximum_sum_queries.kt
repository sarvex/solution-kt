import kotlin.math.max

class BinaryIndexedTree(private val n: Int) {
  private val c: IntArray

  init {
    c = IntArray(n + 1)
    Arrays.fill(c, -1)
  }

  fun update(x: Int, v: Int) {
    var x = x
    while (x <= n) {
      c[x] = max(c[x].toDouble(), v.toDouble()).toInt()
      x += x and -x
    }
  }

  fun query(x: Int): Int {
    var x = x
    var mx = -1
    while (x > 0) {
      mx = max(mx.toDouble(), c[x].toDouble()).toInt()
      x -= x and -x
    }
    return mx
  }
}

internal class Solution {
  fun maximumSumQueries(nums1: IntArray, nums2: IntArray, queries: Array<IntArray>): IntArray {
    val n = nums1.size
    val nums = Array(n) { IntArray(0) }
    for (i in 0 until n) {
      nums[i] = intArrayOf(nums1[i], nums2[i])
    }
    Arrays.sort(nums) { a, b -> b.get(0) - a.get(0) }
    Arrays.sort(nums2)
    val m = queries.size
    val idx = arrayOfNulls<Int>(m)
    for (i in 0 until m) {
      idx[i] = i
    }
    Arrays.sort(idx) { i, j -> queries[j][0] - queries[i][0] }
    val ans = IntArray(m)
    var j = 0
    val tree = BinaryIndexedTree(n)
    for (i in idx) {
      val x = queries[i][0]
      val y = queries[i][1]
      while (j < n && nums[j][0] >= x) {
        val k: Int = n - Arrays.binarySearch(nums2, nums[j][1])
        tree.update(k, nums[j][0] + nums[j][1])
        ++j
      }
      val p: Int = Arrays.binarySearch(nums2, y)
      val k = if (p >= 0) n - p else n + p + 1
      ans[i] = tree.query(k)
    }
    return ans
  }
}
