import kotlin.math.max

class Solution {
  fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
    Arrays.sort(arr)
    arr[0] = 1
    var ans = 1
    for (i in 1 until arr.size) {
      val d = max(0.0, (arr[i] - arr[i - 1] - 1).toDouble()).toInt()
      arr[i] -= d
      ans = max(ans.toDouble(), arr[i].toDouble()).toInt()
    }
    return ans
  }
}
