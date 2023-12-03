import kotlin.math.min

class Solution {
  fun findLengthOfShortestSubarray(arr: IntArray): Int {
    val n = arr.size
    var i = 0
    var j = n - 1
    while (i + 1 < n && arr[i] <= arr[i + 1]) {
      ++i
    }
    while (j - 1 >= 0 && arr[j - 1] <= arr[j]) {
      --j
    }
    if (i >= j) {
      return 0
    }
    var ans = min((n - i - 1).toDouble(), j.toDouble()).toInt()
    var l = 0
    var r = j
    while (l <= i) {
      while (r < n && arr[r] < arr[l]) {
        ++r
      }
      ans = min(ans.toDouble(), (r - l - 1).toDouble()).toInt()
      ++l
    }
    return ans
  }
}
