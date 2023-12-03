class Solution {
  fun maximumCandies(candies: IntArray, k: Long): Int {
    var left = 0
    var right = 1e7.toInt()
    while (left < right) {
      val mid = left + right + 1 shr 1
      var cnt: Long = 0
      for (v in candies) {
        cnt += (v / mid).toLong()
      }
      if (cnt >= k) {
        left = mid
      } else {
        right = mid - 1
      }
    }
    return left
  }
}
