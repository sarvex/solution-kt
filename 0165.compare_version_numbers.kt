internal class Solution {
  fun compareVersion(version1: String, version2: String): Int {
    val m = version1.length
    val n = version2.length
    var i = 0
    var j = 0
    while (i < m || j < n) {
      var a = 0
      var b = 0
      while (i < m && version1[i] != '.') {
        a = a * 10 + (version1[i++].code - '0'.code)
      }
      while (j < n && version2[j] != '.') {
        b = b * 10 + (version2[j++].code - '0'.code)
      }
      if (a != b) {
        return if (a < b) -1 else 1
      }
      ++i
      ++j
    }
    return 0
  }
}
