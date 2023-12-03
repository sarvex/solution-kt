import kotlin.math.min

class Solution {
  fun rearrangeCharacters(s: String, target: String): Int {
    val cnt1 = IntArray(26)
    val cnt2 = IntArray(26)
    for (i in 0 until s.length) {
      ++cnt1[s[i].code - 'a'.code]
    }
    for (i in 0 until target.length) {
      ++cnt2[target[i].code - 'a'.code]
    }
    var ans = 100
    for (i in 0..25) {
      if (cnt2[i] > 0) {
        ans = min(ans.toDouble(), (cnt1[i] / cnt2[i]).toDouble()).toInt()
      }
    }
    return ans
  }
}
