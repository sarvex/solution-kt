internal class Solution {
  fun isStrobogrammatic(num: String): Boolean {
    val d = intArrayOf(0, 1, -1, -1, -1, -1, 9, -1, 8, 6)
    var i = 0
    var j = num.length - 1
    while (i <= j) {
      val a = num[i].code - '0'.code
      val b = num[j].code - '0'.code
      if (d[a] != b) {
        return false
      }
      ++i
      --j
    }
    return true
  }
}
