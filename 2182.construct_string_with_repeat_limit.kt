import kotlin.math.min

class Solution {
  fun repeatLimitedString(s: String, repeatLimit: Int): String {
    val cnt = IntArray(26)
    for (c in s.toCharArray()) {
      cnt[c.code - 'a'.code]++
    }
    val ans = StringBuilder()
    for (i in 25 downTo 0) {
      var j = i - 1
      while (true) {
        for (k in min(repeatLimit.toDouble(), cnt[i].toDouble()) downTo 1) {
          cnt[i]--
          ans.append(('a'.code + i).toChar())
        }
        if (cnt[i] == 0) {
          break
        }
        while (j >= 0 && cnt[j] == 0) {
          --j
        }
        if (j < 0) {
          break
        }
        cnt[j]--
        ans.append(('a'.code + j).toChar())
      }
    }
    return ans.toString()
  }
}
