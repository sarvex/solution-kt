class Solution {
  fun trimMean(arr: IntArray): Double {
    Arrays.sort(arr)
    val n = arr.size
    var s = 0.0
    val start = (n * 0.05).toInt()
    var i = start
    while (i < n - start) {
      s += arr[i].toDouble()
      ++i
    }
    return s / (n * 0.9)
  }
}
