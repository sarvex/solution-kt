internal class Solution {
  fun removeComments(source: Array<String>): List<String> {
    val ans: List<String> = ArrayList()
    val sb = StringBuilder()
    var blockComment = false
    for (s in source) {
      val m = s.length
      var i = 0
      while (i < m) {
        if (blockComment) {
          if (i + 1 < m && s[i] == '*' && s[i + 1] == '/') {
            blockComment = false
            ++i
          }
        } else {
          if (i + 1 < m && s[i] == '/' && s[i + 1] == '*') {
            blockComment = true
            ++i
          } else if (i + 1 < m && s[i] == '/' && s[i + 1] == '/') {
            break
          } else {
            sb.append(s[i])
          }
        }
        ++i
      }
      if (!blockComment && sb.length > 0) {
        ans.add(sb.toString())
        sb.setLength(0)
      }
    }
    return ans
  }
}
