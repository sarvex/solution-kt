internal class Solution {
  fun convert(s: String, numRows: Int): String {
    if (numRows == 1) {
      return s
    }
    val ans = StringBuilder()
    val group = 2 * numRows - 2
    for (i in 1..numRows) {
      var interval = if (i == numRows) group else 2 * numRows - 2 * i
      var idx = i - 1
      while (idx < s.length) {
        ans.append(s[idx])
        idx += interval
        interval = group - interval
        if (interval == 0) {
          interval = group
        }
      }
    }
    return ans.toString()
  }
}
