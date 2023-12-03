internal class Solution {
  fun maximumSwap(num: Int): Int {
    val s = num.toString().toCharArray()
    val n = s.size
    val d = IntArray(n)
    for (i in 0 until n) {
      d[i] = i
    }
    for (i in n - 2 downTo 0) {
      if (s[i] <= s[d[i + 1]]) {
        d[i] = d[i + 1]
      }
    }
    for (i in 0 until n) {
      val j = d[i]
      if (s[i] < s[j]) {
        val t = s[i]
        s[i] = s[j]
        s[j] = t
        break
      }
    }
    return String(s).toInt()
  }
}
