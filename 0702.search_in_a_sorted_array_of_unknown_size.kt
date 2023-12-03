/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */
internal class Solution {
  fun search(reader: ArrayReader, target: Int): Int {
    var left = 0
    var right = 20000
    while (left < right) {
      val mid = left + right shr 1
      if (reader.get(mid) >= target) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return if (reader.get(left) === target) left else -1
  }
}
