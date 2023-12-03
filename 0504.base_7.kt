internal class Solution {
  fun convertToBase7(num: Int): String {
    var num = num
    if (num == 0) {
      return "0"
    }
    if (num < 0) {
      return "-" + convertToBase7(-num)
    }
    val sb = StringBuilder()
    while (num != 0) {
      sb.append(num % 7)
      num /= 7
    }
    return sb.reverse().toString()
  }
}
