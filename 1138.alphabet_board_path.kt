internal class Solution {
  fun alphabetBoardPath(target: String): String {
    val ans = StringBuilder()
    var i = 0
    var j = 0
    for (k in 0 until target.length) {
      val v = target[k].code - 'a'.code
      val x = v / 5
      val y = v % 5
      while (j > y) {
        --j
        ans.append('L')
      }
      while (i > x) {
        --i
        ans.append('U')
      }
      while (j < y) {
        ++j
        ans.append('R')
      }
      while (i < x) {
        ++i
        ans.append('D')
      }
      ans.append("!")
    }
    return ans.toString()
  }
}
