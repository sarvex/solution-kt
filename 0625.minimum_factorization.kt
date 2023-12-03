internal class Solution {
  fun smallestFactorization(num: Int): Int {
    var num = num
    if (num < 2) {
      return num
    }
    var ans: Long = 0
    var mul: Long = 1
    for (i in 9 downTo 2) {
      if (num % i == 0) {
        while (num % i == 0) {
          num /= i
          ans = mul * i + ans
          mul *= 10
        }
      }
    }
    return if (num < 2 && ans <= Int.MAX_VALUE) ans.toInt() else 0
  }
}
