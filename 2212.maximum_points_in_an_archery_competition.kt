class Solution {
  fun maximumBobPoints(numArrows: Int, aliceArrows: IntArray): IntArray {
    var numArrows = numArrows
    val n = aliceArrows.size
    var mx = -1
    var state = 0
    for (mask in 1 until (1 shl n)) {
      var cnt = 0
      var points = 0
      for (i in 0 until n) {
        if (mask shr i and 1 == 1) {
          cnt += aliceArrows[i] + 1
          points += i
        }
      }
      if (cnt <= numArrows && mx < points) {
        state = mask
        mx = points
      }
    }
    val ans = IntArray(n)
    for (i in 0 until n) {
      if (state shr i and 1 == 1) {
        ans[i] = aliceArrows[i] + 1
        numArrows -= ans[i]
      }
    }
    ans[0] += numArrows
    return ans
  }
}
