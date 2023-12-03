class Solution {
  fun sumFourDivisors(nums: IntArray): Int {
    var ans = 0
    for (x in nums) {
      ans += f(x)
    }
    return ans
  }

  private fun f(x: Int): Int {
    var cnt = 2
    var s = x + 1
    for (i in 2..x / i) {
      if (x % i == 0) {
        ++cnt
        s += i
        if (i * i != x) {
          ++cnt
          s += x / i
        }
      }
    }
    return if (cnt == 4) s else 0
  }
}
