class Solution {
  fun maximumScore(a: Int, b: Int, c: Int): Int {
    val s = intArrayOf(a, b, c)
    Arrays.sort(s)
    return if (s[0] + s[1] < s[2]) {
      s[0] + s[1]
    } else a + b + c shr 1
  }
}
