class Solution {
  fun largestInteger(num: Int): Int {
    val cnt = IntArray(10)
    var x = num
    while (x != 0) {
      cnt[x % 10]++
      x /= 10
    }
    x = num
    var ans = 0
    var t = 1
    while (x != 0) {
      val v = x % 10
      x /= 10
      for (y in 0..9) {
        if (v xor y and 1 == 0 && cnt[y] > 0) {
          cnt[y]--
          ans += y * t
          t *= 10
          break
        }
      }
    }
    return ans
  }
}
