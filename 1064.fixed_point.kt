internal class Solution {
  fun fixedPoint(arr: IntArray): Int {
    var left = 0
    var right = arr.size - 1
    while (left < right) {
      val mid = left + right shr 1
      if (arr[mid] >= mid) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return if (arr[left] == left) left else -1
  }
}
