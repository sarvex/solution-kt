class Solution {
  fun totalMoney(n: Int): Int {
    val a = n / 7
    val b = n % 7
    return (28 + 28 + 7 * (a - 1)) * a / 2 + (a * 2 + b + 1) * b / 2
  }
}
