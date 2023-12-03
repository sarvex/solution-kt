internal class Solution {
  fun toHex(num: Int): String {
    var num = num
    if (num == 0) {
      return "0"
    }
    val sb = StringBuilder()
    while (num != 0) {
      val x = num and 15
      if (x < 10) {
        sb.append(x)
      } else {
        sb.append((x - 10 + 'a'.code).toChar())
      }
      num = num ushr 4
    }
    return sb.reverse().toString()
  }
}
