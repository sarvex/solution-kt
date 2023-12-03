class Solution {
  fun reinitializePermutation(n: Int): Int {
    var ans = 0
    var i = 1
    while (true) {
      ++ans
      i = if (i < n shr 1) {
        i shl 1
      } else {
        i - (n shr 1) shl 1 or 1
      }
      if (i == 1) {
        return ans
      }
    }
  }
}
