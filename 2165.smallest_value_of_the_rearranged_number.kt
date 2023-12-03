import kotlin.math.abs

class Solution {
  fun smallestNumber(num: Long): Long {
    var num = num
    if (num == 0L) {
      return 0
    }
    val cnt = IntArray(10)
    val neg = num < 0
    num = abs(num.toDouble()).toLong()
    while (num != 0L) {
      cnt[(num % 10).toInt()]++
      num /= 10
    }
    var ans: Long = 0
    if (neg) {
      for (i in 9 downTo 0) {
        while (cnt[i]-- > 0) {
          ans = ans * 10 + i
        }
      }
      return -ans
    }
    if (cnt[0] > 0) {
      for (i in 1..9) {
        if (cnt[i] > 0) {
          ans = ans * 10 + i
          cnt[i]--
          break
        }
      }
    }
    for (i in 0..9) {
      while (cnt[i]-- > 0) {
        ans = ans * 10 + i
      }
    }
    return ans
  }
}
