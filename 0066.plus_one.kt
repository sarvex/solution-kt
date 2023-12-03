internal class Solution {
  fun plusOne(digits: IntArray): IntArray {
    var digits = digits
    val n = digits.size
    for (i in n - 1 downTo 0) {
      ++digits[i]
      digits[i] %= 10
      if (digits[i] != 0) {
        return digits
      }
    }
    digits = IntArray(n + 1)
    digits[0] = 1
    return digits
  }
}
