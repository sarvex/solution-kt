import kotlin.math.min

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 * public int get(int row, int col) {}
 * public List<Integer> dimensions {}
 * };
</Integer> */
internal class Solution {
  fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
    val scale: List<Int> = binaryMatrix.dimensions()
    val rows = scale[0]
    val cols = scale[1]
    var res = -1
    for (row in 0 until rows) {
      var left = 0
      var right = cols - 1
      while (left < right) {
        val mid = left + right shr 1
        if (binaryMatrix.get(row, mid) === 1) {
          right = mid
        } else {
          left = mid + 1
        }
      }
      if (binaryMatrix.get(row, left) === 1) {
        res = if (res == -1) {
          left
        } else {
          min(res.toDouble(), left.toDouble()).toInt()
        }
      }
    }
    return res
  }
}
