internal class Solution {
  fun integerReplacement(n: Int): Int {
    var n = n
    var ans = 0
    while (n != 1) {
      if (n and 1 == 0) {
        n = n ushr 1
      } else if (n != 3 && n and 3 == 3) {
        ++n
      } else {
        --n
      }
      ++ans
    }
    return ans
  }
}
