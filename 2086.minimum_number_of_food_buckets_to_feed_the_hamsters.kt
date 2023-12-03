internal class Solution {
  fun minimumBuckets(street: String): Int {
    val n = street.length
    var ans = 0
    var i = 0
    while (i < n) {
      if (street[i] == 'H') {
        if (i + 1 < n && street[i + 1] == '.') {
          ++ans
          i += 2
        } else if (i > 0 && street[i - 1] == '.') {
          ++ans
        } else {
          return -1
        }
      }
      ++i
    }
    return ans
  }
}
