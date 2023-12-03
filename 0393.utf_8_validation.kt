internal class Solution {
  fun validUtf8(data: IntArray): Boolean {
    var n = 0
    for (v in data) {
      if (n > 0) {
        if (v shr 6 != 2) {
          return false
        }
        --n
      } else if (v shr 7 == 0) {
        n = 0
      } else if (v shr 5 == 6) {
        n = 1
      } else if (v shr 4 == 14) {
        n = 2
      } else if (v shr 3 == 30) {
        n = 3
      } else {
        return false
      }
    }
    return n == 0
  }
}
