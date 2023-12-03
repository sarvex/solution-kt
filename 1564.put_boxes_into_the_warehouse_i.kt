import kotlin.math.min

class Solution {
  fun maxBoxesInWarehouse(boxes: IntArray, warehouse: IntArray): Int {
    val n = warehouse.size
    val left = IntArray(n)
    left[0] = warehouse[0]
    for (i in 1 until n) {
      left[i] = min(left[i - 1].toDouble(), warehouse[i].toDouble()).toInt()
    }
    Arrays.sort(boxes)
    var i = 0
    var j = n - 1
    while (i < boxes.size) {
      while (j >= 0 && left[j] < boxes[i]) {
        --j
      }
      if (j < 0) {
        break
      }
      ++i
      --j
    }
    return i
  }
}
