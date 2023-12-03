import kotlin.math.min

class Solution {
  private var ans = 0
  fun minCharacters(a: String, b: String): Int {
    val m = a.length
    val n = b.length
    val cnt1 = IntArray(26)
    val cnt2 = IntArray(26)
    for (i in 0 until m) {
      ++cnt1[a[i].code - 'a'.code]
    }
    for (i in 0 until n) {
      ++cnt2[b[i].code - 'a'.code]
    }
    ans = m + n
    for (i in 0..25) {
      ans = min(ans.toDouble(), (m + n - cnt1[i] - cnt2[i]).toDouble()).toInt()
    }
    f(cnt1, cnt2)
    f(cnt2, cnt1)
    return ans
  }

  private fun f(cnt1: IntArray, cnt2: IntArray) {
    for (i in 1..25) {
      var t = 0
      for (j in i..25) {
        t += cnt1[j]
      }
      for (j in 0 until i) {
        t += cnt2[j]
      }
      ans = min(ans.toDouble(), t.toDouble()).toInt()
    }
  }
}
