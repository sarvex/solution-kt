internal class Solution {
  fun titleToNumber(columnTitle: String): Int {
    var res = 0
    for (c in columnTitle.toCharArray()) {
      res = res * 26 + (c.code - 'A'.code + 1)
    }
    return res
  }
}
