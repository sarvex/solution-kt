import kotlin.math.max
import kotlin.math.min

class Solution {
  fun maxBoxesInWarehouse(boxes: IntArray, warehouse: IntArray): Int {
    val n = warehouse.size
    val left = IntArray(n)
    val right = IntArray(n)
    val inf = 1 shl 30
    left[0] = inf
    right[n - 1] = inf
    for (i in 1 until n) {
      left[i] = min(left[i - 1].toDouble(), warehouse[i - 1].toDouble()).toInt()
    }
    for (i in n - 2 downTo 0) {
      right[i] = min(right[i + 1].toDouble(), warehouse[i + 1].toDouble()).toInt()
    }
    for (i in 0 until n) {
      warehouse[i] = min(warehouse[i].toDouble(), max(left[i].toDouble(), right[i].toDouble()))
        .toInt()
    }
    Arrays.sort(boxes)
    Arrays.sort(warehouse)
    var ans = 0
    var i = 0
    for (x in boxes) {
      while (i < n && warehouse[i] < x) {
        ++i
      }
      if (i == n) {
        break
      }
      ++ans
      ++i
    }
    return ans
  }
}
