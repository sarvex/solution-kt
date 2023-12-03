internal class Solution {
  fun largeGroupPositions(s: String): List<List<Int>> {
    val n = s.length
    var i = 0
    val ans: List<List<Int>> = ArrayList()
    while (i < n) {
      var j = i
      while (j < n && s[j] == s[i]) {
        ++j
      }
      if (j - i >= 3) {
        ans.add(Arrays.asList(i, j - 1))
      }
      i = j
    }
    return ans
  }
}
