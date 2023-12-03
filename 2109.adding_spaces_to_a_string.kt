internal class Solution {
  fun addSpaces(s: String, spaces: IntArray): String {
    val ans = StringBuilder()
    var i = 0
    var j = 0
    while (i < s.length) {
      if (j < spaces.size && i == spaces[j]) {
        ans.append(' ')
        ++j
      }
      ans.append(s[i])
      ++i
    }
    return ans.toString()
  }
}
