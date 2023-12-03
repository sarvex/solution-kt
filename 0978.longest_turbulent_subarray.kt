import kotlin.math.max

class Solution {
  fun maxTurbulenceSize(arr: IntArray): Int {
    var ans = 1
    var f = 1
    var g = 1
    for (i in 1 until arr.size) {
      val ff = if (arr[i - 1] < arr[i]) g + 1 else 1
      val gg = if (arr[i - 1] > arr[i]) f + 1 else 1
      f = ff
      g = gg
      ans = max(ans.toDouble(), max(f.toDouble(), g.toDouble())).toInt()
    }
    return ans
  }
}
