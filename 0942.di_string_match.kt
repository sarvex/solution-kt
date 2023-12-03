class Solution {
  fun diStringMatch(s: String): IntArray {
    val n = s.length
    var low = 0
    var high = n
    val ans = IntArray(n + 1)
    for (i in 0 until n) {
      if (s[i] == 'I') {
        ans[i] = low++
      } else {
        ans[i] = high--
      }
    }
    ans[n] = low
    return ans
  }
}
