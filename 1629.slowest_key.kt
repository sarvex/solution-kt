class Solution {
  fun slowestKey(releaseTimes: IntArray, keysPressed: String): Char {
    var ans = keysPressed[0]
    var mx = releaseTimes[0]
    for (i in 1 until releaseTimes.size) {
      val d = releaseTimes[i] - releaseTimes[i - 1]
      if (d > mx || d == mx && keysPressed[i] > ans) {
        mx = d
        ans = keysPressed[i]
      }
    }
    return ans
  }
}
