import kotlin.math.max

internal class Solution {
  fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
    Arrays.sort(items) { a, b -> a.get(0) - b.get(0) }
    for (i in 1 until items.size) {
      items[i][1] = max(items[i - 1][1].toDouble(), items[i][1].toDouble()).toInt()
    }
    val n = queries.size
    val ans = IntArray(n)
    for (i in 0 until n) {
      var left = 0
      var right = items.size
      while (left < right) {
        val mid = left + right shr 1
        if (items[mid][0] > queries[i]) {
          right = mid
        } else {
          left = mid + 1
        }
      }
      if (left > 0) {
        ans[i] = items[left - 1][1]
      }
    }
    return ans
  }
}
