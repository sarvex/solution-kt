class Solution {
  fun minimizeXor(num1: Int, num2: Int): Int {
    var num1 = num1
    var cnt1 = Integer.bitCount(num1)
    val cnt2 = Integer.bitCount(num2)
    while (cnt1 > cnt2) {
      num1 = num1 and num1 - 1
      --cnt1
    }
    while (cnt1 < cnt2) {
      num1 = num1 or num1 + 1
      ++cnt1
    }
    return num1
  }
}
