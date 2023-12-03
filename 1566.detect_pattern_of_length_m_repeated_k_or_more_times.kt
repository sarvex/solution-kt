class Solution {
  fun containsPattern(arr: IntArray, m: Int, k: Int): Boolean {
    val n = arr.size
    for (i in 0..n - m * k) {
      var j = 0
      while (j < m * k) {
        if (arr[i + j] != arr[i + j % m]) {
          break
        }
        ++j
      }
      if (j == m * k) {
        return true
      }
    }
    return false
  }
}
