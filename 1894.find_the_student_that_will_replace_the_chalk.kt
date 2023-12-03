class Solution {
  fun chalkReplacer(chalk: IntArray, k: Int): Int {
    var k = k
    val n = chalk.size
    val s = LongArray(n + 1)
    s[0] = chalk[0].toLong()
    for (i in 1 until n) {
      s[i] = s[i - 1] + chalk[i]
    }
    k %= s[n - 1].toInt()
    var left = 0
    var right = n - 1
    while (left < right) {
      val mid = left + right shr 1
      if (s[mid] > k) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
