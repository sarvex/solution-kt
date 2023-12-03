class Solution {
  fun divisorSubstrings(num: Int, k: Int): Int {
    var ans = 0
    val s = "" + num
    for (i in 0 until s.length - k + 1) {
      val t = s.substring(i, i + k).toInt()
      if (t != 0 && num % t == 0) {
        ++ans
      }
    }
    return ans
  }
}
