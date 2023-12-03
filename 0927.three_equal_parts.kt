internal class Solution {
  private var arr: IntArray
  fun threeEqualParts(arr: IntArray): IntArray {
    this.arr = arr
    var cnt = 0
    val n = arr.size
    for (v in arr) {
      cnt += v
    }
    if (cnt % 3 != 0) {
      return intArrayOf(-1, -1)
    }
    if (cnt == 0) {
      return intArrayOf(0, n - 1)
    }
    cnt /= 3
    var i = find(1)
    var j = find(cnt + 1)
    var k = find(cnt * 2 + 1)
    while (k < n && arr[i] == arr[j] && arr[j] == arr[k]) {
      ++i
      ++j
      ++k
    }
    return if (k == n) intArrayOf(i - 1, j) else intArrayOf(-1, -1)
  }

  private fun find(x: Int): Int {
    var s = 0
    for (i in arr.indices) {
      s += arr[i]
      if (s == x) {
        return i
      }
    }
    return 0
  }
}
