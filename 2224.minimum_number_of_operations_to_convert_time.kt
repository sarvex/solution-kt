class Solution {
  fun convertTime(current: String, correct: String): Int {
    val a = (current.substring(0, 2).toInt() * 60
        + current.substring(3).toInt())
    val b = (correct.substring(0, 2).toInt() * 60
        + correct.substring(3).toInt())
    var ans = 0
    var d = b - a
    for (i in Arrays.asList(60, 15, 5, 1)) {
      ans += d / i
      d %= i
    }
    return ans
  }
}
