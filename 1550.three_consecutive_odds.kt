class Solution {
  fun threeConsecutiveOdds(arr: IntArray): Boolean {
    var cnt = 0
    for (v in arr) {
      if (v % 2 == 1) {
        ++cnt
      } else {
        cnt = 0
      }
      if (cnt == 3) {
        return true
      }
    }
    return false
  }
}
