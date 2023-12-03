import kotlin.math.min

internal class Solution {
  fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
    Arrays.sort(arr)
    val n = arr.size
    var mi = 1 shl 30
    for (i in 0 until n - 1) {
      mi = min(mi.toDouble(), (arr[i + 1] - arr[i]).toDouble()).toInt()
    }
    val ans: List<List<Int>> = ArrayList()
    for (i in 0 until n - 1) {
      if (arr[i + 1] - arr[i] == mi) {
        ans.add(List.of(arr[i], arr[i + 1]))
      }
    }
    return ans
  }
}
