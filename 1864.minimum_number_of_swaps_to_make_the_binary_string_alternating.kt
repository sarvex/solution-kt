import kotlin.math.min

class Solution {
  fun minSwaps(s: String): Int {
    var s0n0 = 0
    var s0n1 = 0
    var s1n0 = 0
    var s1n1 = 0
    for (i in 0 until s.length) {
      if (i and 1 == 0) {
        if (s[i] != '0') {
          s0n0 += 1
        } else {
          s1n1 += 1
        }
      } else {
        if (s[i] != '0') {
          s1n0 += 1
        } else {
          s0n1 += 1
        }
      }
    }
    if (s0n0 != s0n1 && s1n0 != s1n1) {
      return -1
    }
    if (s0n0 != s0n1) {
      return s1n0
    }
    return if (s1n0 != s1n1) {
      s0n0
    } else min(s0n0.toDouble(), s1n0.toDouble()).toInt()
  }
}
