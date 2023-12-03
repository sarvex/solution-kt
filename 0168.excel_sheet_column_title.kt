internal class Solution {
  fun convertToTitle(columnNumber: Int): String {
    var columnNumber = columnNumber
    val res = StringBuilder()
    while (columnNumber != 0) {
      --columnNumber
      res.append(('A'.code + columnNumber % 26).toChar())
      columnNumber /= 26
    }
    return res.reverse().toString()
  }
}
