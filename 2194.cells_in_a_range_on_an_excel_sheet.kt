class Solution {
  fun cellsInRange(s: String): List<String> {
    val ans: List<String> = ArrayList()
    var i = s[0]
    while (i <= s[3]) {
      var j = s[1]
      while (j <= s[4]) {
        ans.add(i.toString() + "" + j)
        ++j
      }
      ++i
    }
    return ans
  }
}
