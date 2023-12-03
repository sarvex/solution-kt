internal class Solution {
  fun reorderedPowerOf2(n: Int): Boolean {
    val s = convert(n)
    var i = 1
    while (i <= 10.pow(9.0)) {
      if (s == convert(i)) {
        return true
      }
      i = i shl 1
    }
    return false
  }

  private fun convert(n: Int): String {
    var n = n
    val cnt = CharArray(10)
    while (n > 0) {
      cnt[n % 10]++
      n /= 10
    }
    return String(cnt)
  }
}
