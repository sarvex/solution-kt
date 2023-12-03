import kotlin.math.max

internal class Solution {
  fun maximumSum(arr: IntArray): Int {
    val n = arr.size
    val left = IntArray(n)
    val right = IntArray(n)
    var ans = -(1 shl 30)
    run {
      var i = 0
      var s = 0
      while (i < n) {
        s = (max(s.toDouble(), 0.0) + arr[i]).toInt()
        left[i] = s
        ans = max(ans.toDouble(), left[i].toDouble()).toInt()
        ++i
      }
    }
    run {
      var i = n - 1
      var s = 0
      while (i >= 0) {
        s = (max(s.toDouble(), 0.0) + arr[i]).toInt()
        right[i] = s
        --i
      }
    }
    for (i in 1 until n - 1) {
      ans = max(ans.toDouble(), (left[i - 1] + right[i + 1]).toDouble()).toInt()
    }
    return ans
  }
}
