class Solution {
  fun countOperations(num1: Int, num2: Int): Int {
    var num1 = num1
    var num2 = num2
    var ans = 0
    while (num1 != 0 && num2 != 0) {
      if (num1 >= num2) {
        num1 -= num2
      } else {
        num2 -= num1
      }
      ++ans
    }
    return ans
  }
}
