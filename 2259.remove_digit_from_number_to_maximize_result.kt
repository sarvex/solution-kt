class Solution {
  fun removeDigit(number: String, digit: Char): String {
    var last = -1
    val n = number.length
    for (i in 0 until n) {
      val d = number[i]
      if (d == digit) {
        last = i
        if (i + 1 < n && d < number[i + 1]) {
          break
        }
      }
    }
    return number.substring(0, last) + number.substring(last + 1)
  }
}
