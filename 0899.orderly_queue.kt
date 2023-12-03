internal class Solution {
  fun orderlyQueue(s: String, k: Int): String {
    if (k == 1) {
      var ans = s
      val sb = StringBuilder(s)
      for (i in 0 until s.length - 1) {
        sb.append(sb[0]).deleteCharAt(0)
        if (sb.toString().compareTo(ans) < 0) {
          ans = sb.toString()
        }
      }
      return ans
    }
    val cs = s.toCharArray()
    Arrays.sort(cs)
    return String(cs)
  }
}
