import kotlin.math.max

internal class Solution {
  fun longestMountain(arr: IntArray): Int {
    val n = arr.size
    var ans = 0
    var l = 0
    var r = 0
    while (l + 2 < n) {
      r = l + 1
      if (arr[l] < arr[r]) {
        while (r + 1 < n && arr[r] < arr[r + 1]) {
          ++r
        }
        if (r + 1 < n && arr[r] > arr[r + 1]) {
          while (r + 1 < n && arr[r] > arr[r + 1]) {
            ++r
          }
          ans = max(ans.toDouble(), (r - l + 1).toDouble()).toInt()
        } else {
          ++r
        }
      }
      l = r
    }
    return ans
  }
}
