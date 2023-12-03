internal class Solution {
  fun complexNumberMultiply(num1: String, num2: String): String {
    val c1 = num1.split("\\+|i".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val c2 = num2.split("\\+|i".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val a = c1[0].toInt()
    val b = c1[1].toInt()
    val c = c2[0].toInt()
    val d = c2[1].toInt()
    return String.format("%d+%di", a * c - b * d, a * d + c * b)
  }
}
