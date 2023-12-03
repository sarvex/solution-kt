internal class Solution {
  fun peakIndexInMountainArray(arr: IntArray): Int {
    var left = 1
    var right = arr.size - 2
    while (left < right) {
      val mid = left + right shr 1
      if (arr[mid] > arr[mid + 1]) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
