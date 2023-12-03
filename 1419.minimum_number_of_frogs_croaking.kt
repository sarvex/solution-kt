import kotlin.math.max

class Solution {
  fun minNumberOfFrogs(croakOfFrogs: String): Int {
    val n = croakOfFrogs.length
    if (n % 5 != 0) {
      return -1
    }
    val idx = IntArray(26)
    val s = "croak"
    for (i in 0..4) {
      idx[s[i].code - 'a'.code] = i
    }
    val cnt = IntArray(5)
    var ans = 0
    var x = 0
    for (k in 0 until n) {
      val i = idx[croakOfFrogs[k].code - 'a'.code]
      ++cnt[i]
      if (i == 0) {
        ans = max(ans.toDouble(), ++x.toDouble()).toInt()
      } else {
        if (--cnt[i - 1] < 0) {
          return -1
        }
        if (i == 4) {
          --x
        }
      }
    }
    return if (x > 0) -1 else ans
  }
}
