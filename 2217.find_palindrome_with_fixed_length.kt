class Solution {
  fun kthPalindrome(queries: IntArray, intLength: Int): LongArray {
    val n = queries.size
    val ans = LongArray(n)
    val l = intLength + 1 shr 1
    val start = 10.pow((l - 1).toDouble()) as Long
    val end = 10.pow(l.toDouble()) as Long - 1
    for (i in 0 until n) {
      val v = start + queries[i] - 1
      if (v > end) {
        ans[i] = -1
        continue
      }
      var s = "" + v
      s += StringBuilder(s).reverse().substring(intLength % 2)
      ans[i] = s.toLong()
    }
    return ans
  }
}
