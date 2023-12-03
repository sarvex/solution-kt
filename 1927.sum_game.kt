class Solution {
  fun sumGame(num: String): Boolean {
    val n = num.length
    var cnt1 = 0
    var cnt2 = 0
    var s1 = 0
    var s2 = 0
    for (i in 0 until n / 2) {
      if (num[i] == '?') {
        cnt1++
      } else {
        s1 += num[i].code - '0'.code
      }
    }
    for (i in n / 2 until n) {
      if (num[i] == '?') {
        cnt2++
      } else {
        s2 += num[i].code - '0'.code
      }
    }
    return (cnt1 + cnt2) % 2 == 1 || s1 - s2 != 9 * (cnt2 - cnt1) / 2
  }
}
