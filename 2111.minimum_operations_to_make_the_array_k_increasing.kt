internal class Solution {
  fun kIncreasing(arr: IntArray, k: Int): Int {
    val n = arr.size
    var ans = 0
    for (i in 0 until k) {
      val t: List<Int> = ArrayList()
      var j = i
      while (j < n) {
        t.add(arr[j])
        j += k
      }
      ans += lis(t)
    }
    return ans
  }

  private fun lis(arr: List<Int>): Int {
    val t: List<Int> = ArrayList()
    for (x in arr) {
      val idx = searchRight(t, x)
      if (idx == t.size()) {
        t.add(x)
      } else {
        t.set(idx, x)
      }
    }
    return arr.size() - t.size()
  }

  private fun searchRight(arr: List<Int>, x: Int): Int {
    var left = 0
    var right: Int = arr.size()
    while (left < right) {
      val mid = left + right shr 1
      if (arr[mid] > x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
